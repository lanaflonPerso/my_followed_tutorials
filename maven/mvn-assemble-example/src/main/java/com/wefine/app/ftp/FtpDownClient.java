package com.wefine.app.ftp;

import com.wefine.app.encrypt.Encryptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class FtpDownClient {
    private final FTPClient client;

    /**
     * 构造函数，初始化客户端。
     *
     * @param host 加密的主机串
     * @param user 加密的用户名
     * @param pwd  加密的用户密码
     * @throws Exception 异常
     */
    public FtpDownClient(String host, String user, String pwd) throws Exception {
        log.info("Initializing client...");
        Encryptor encryptor = new Encryptor();
        host = encryptor.decrypt(host);
        user = encryptor.decrypt(user);
        pwd = encryptor.decrypt(pwd);

        client = new FTPClient();
        client.setControlEncoding("UTF-8");
        client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        client.connect(host);

        int reply = client.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            client.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        client.login(user, pwd);
        client.setFileType(FTP.BINARY_FILE_TYPE);
        client.enterLocalPassiveMode();
    }

    public void down(String remote, String local) throws IOException {
        log.info("Downloading..." + remote);
        try (FileOutputStream fos = new FileOutputStream(local)) {
            client.retrieveFile(remote, fos);
        }
    }

    public void disconnect() {
        if (client.isConnected()) {
            try {
                client.logout();
                client.disconnect();
            } catch (IOException ignored) {
            }
        }
    }
}
