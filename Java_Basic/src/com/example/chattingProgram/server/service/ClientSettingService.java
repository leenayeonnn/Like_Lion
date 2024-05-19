package com.example.chattingProgram.server.service;

import com.example.chattingProgram.server.domain.Client;

import java.io.IOException;
import java.util.Map;

public class ClientSettingService {

    public static String inputNickname(Client me, Map<String, Client> clients) throws IOException {
        String nickname;
        while ((nickname = me.inMessage()) != null) {
            if (nickname.isBlank()) {
                me.outMessage("nameBlank");
            } else if (clients.containsKey(nickname)) {
                me.outMessage("nameDuplicate");
            } else {
                break;
            }
        }
        return nickname;
    }
}
