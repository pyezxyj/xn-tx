package com.std.forum.proxy;

import com.std.forum.api.IProcessor;
import com.std.forum.common.JsonUtil;
import com.std.forum.common.ReflectUtil;
import com.std.forum.enums.EErrorCode;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;

public class DispatcherImpl implements IDispatcher {

    @Override
    public String doDispatcher(String transcode, String inputParams) {
        String result = null;
        ReturnMessage rm = new ReturnMessage();
        try {
            // 加载配置文件,proxy实例化
            String classname = "com.std.forum.api.impl.XNOther";
            // ConfigDescribe configDescribe = ConfigLoader.loadConfig();
            // if (StringUtils.isNotBlank(transcode) && configDescribe != null)
            // {
            // List<String> codeList = configDescribe.getCodeList();
            // if (codeList.contains(transcode)) {
            // classname = "com.std.forum.api.impl.XN" + transcode;
            // }
            // }
            classname = "com.std.forum.api.impl.XN" + transcode;
            IProcessor processor = (IProcessor) ReflectUtil
                .getInstance(classname);
            // 接口调用
            Object data = processor.doProcessor(inputParams);
            rm.setErrorCode(EErrorCode.SUCCESS.getCode());
            rm.setErrorInfo(EErrorCode.SUCCESS.getValue());
            rm.setData(data);
        } catch (Exception e) {
            if (e instanceof BizException) {
                rm.setErrorCode(EErrorCode.BIZ_ERR.getCode());
                rm.setErrorInfo(((BizException) e).getErrorMessage());
                rm.setData("");
            } else if (e instanceof ParaException) {
                rm.setErrorCode(EErrorCode.PARA_ERR.getCode());
                rm.setErrorInfo(((ParaException) e).getErrorMessage());
                rm.setData("");
            } else if (e instanceof NullPointerException) {
                rm.setErrorCode(EErrorCode.OTHER_ERR.getCode());
                // rm.setErrorInfo("NPE");
                rm.setErrorInfo("系统错误，请联系管理员");
                rm.setData("");
            } else {
                rm.setErrorCode(EErrorCode.OTHER_ERR.getCode());
                // rm.setErrorInfo(e.getMessage());
                rm.setErrorInfo("系统错误，请联系管理员");
                rm.setData("");
            }
        } finally {
            result = JsonUtil.Object2Json(rm);
        }
        return result;
    }
}
