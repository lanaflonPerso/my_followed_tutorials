package com.wefine.app;

import com.wefine.app.ftp.FtpDownClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) throws Exception {
        String host = System.getProperty("host", "7Mu43LHz0AvkE0mMUlhwq4VnA3B87WIx");
        String user = System.getProperty("user", "w28Y5wDj9gkgxFYGaJtrgw==");
        String pwd = System.getProperty("pwd", "PcY+nz3+i8RjE8aXhVNNdA==");

        try {
            FtpDownClient client = new FtpDownClient(host, user, pwd);
            client.down("/home/wefine/logs/a.log", "a.log");
        } catch (Exception e) {
           log.info("Download Failure!", e);
        }
    }
}
