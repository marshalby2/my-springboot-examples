package com.my.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @Description TODO
 * @Author marshal
 * @Date 19/5/20 4:02 PM
 */
public class FtpUtil {


    private static Logger logger = Logger.getLogger("FtpUtil");

    /**
     *  获取FTP连接客户端
     *
     * @param host
     * @param port
     * @param username
     * @param password
     * @return
     */
    public static FTPClient getFtpClient(String host, int port, String username, String password) {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(1000 * 30);
        ftpClient.setControlEncoding("utf-8");
        ftpClient.enterLocalPassiveMode();  // 设置被动模式
        try {
//            ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE); // 设置传输模式为二进制
            ftpClient.connect(host, port);
            ftpClient.login(username, password);
        } catch (IOException e) {
            logger.warning(" ================== FTP  connect failed ================== ");
            e.printStackTrace();
        }
        return ftpClient;
    }

}
