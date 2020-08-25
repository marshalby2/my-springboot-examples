package com.my.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

/**
 * @Description TODO
 * @Author marshal
 * @Date 19/5/20 4:25 PM
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String host = "203.195.158.223";
        int port = 21;
        String username = "ftpuser";
        String password = "ftpuser";

        // 获得FTP客户端连接
        FTPClient ftpClient = FtpUtil.getFtpClient(host, port, username, password);
        // 工作路径
        System.out.println("workDirectory : " + ftpClient.printWorkingDirectory());
    }

}
