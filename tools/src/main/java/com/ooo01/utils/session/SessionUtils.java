package com.ooo01.utils.session;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * {@code @Description:}
 */
public class SessionUtils {
    /**
     * 打印HttpSession域中的所有参数
     *
     * @param httpSession 会话对象
     */
    public static void printHttpSessionAll(HttpSession httpSession) {
        Enumeration<String> keyEnumeration = httpSession.getAttributeNames();
        while (keyEnumeration.hasMoreElements()) {
            String key = keyEnumeration.nextElement();
            System.out.println("参数名：" + key + "\t" + "参数值：" + httpSession.getAttribute(key));
        }
    }
}