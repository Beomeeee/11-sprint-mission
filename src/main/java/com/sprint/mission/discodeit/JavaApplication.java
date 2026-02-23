package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFMessageService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;

import java.util.List;

public class JavaApplication {
    public static void main(String[] args) {
        JCFUserService userService = new JCFUserService();
        JCFChannelService channelService = new JCFChannelService();
        JCFMessageService messageService = new JCFMessageService();

        System.out.println("===== 1. 등록 (create) 테스트 =====");
        User user = userService.create("beomsoo", "test@test.com", "1234");
        Channel channel = channelService.create("자바공부방", "자바를 공부하는 채널입니다.");
        Message message = messageService.create("안녕하세요!", user.getId(), channel.getId());

        System.out.println("등록된 유저: " + user.getUserName());
        System.out.println("등록된 채널: " + channel.getChannelName());
        System.out.println("등록된 메시지: " + message.getContent());

        System.out.println("\r\n===== 2. 조회 (Read) 테스트 =====");
        User foundUser = userService.read(user.getId());
        System.out.println("단건 조회 결과: " + foundUser.getUserName());

        List<User> allUser = userService.readAll();
        System.out.println("전체 사용자 수: " + allUser.size());

        System.out.println("\r\n===== 3. 수정 (Update) 테스트 =====");
        userService.update(user.getId(), "spring_master", "new@test.com", "5678");
        System.out.println("수정된 이름 확인: " + userService.read(user.getId()).getUserName());
        System.out.println("수정된 시간(updatedAt): " + userService.read(user.getId()).getUpdatedAt());

        System.out.println("\r\n===== 4. 삭제 (Delete) 테스트 =====");
        messageService.delete(message.getId());
        if (messageService.read(message.getId()) == null) {
            System.out.println("메시지가 성공적으로 삭제되었습니다.");
        }
    }
}
