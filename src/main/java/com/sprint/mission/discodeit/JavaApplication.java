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

        // 1. 등록 테스트
        System.out.println("===== 1. 등록 (create) 테스트 =====");

        // 유저 2명 생성 (이름, 이메일, 비밀번호)
        User user1 = userService.create("beomsoo", "test@test.com", "1234");
        User user2 = userService.create("hyunji", "test1@test.com", "2345");

        // 채널 생성 (채널명, 설명)
        Channel channel = channelService.create("자바공부방", "자바를 공부하는 채널입니다.");

        // 누가(senderId), 어느 채널에(channelId) 보냈는지 정보를 담아 메시지 생성
        Message message1 = messageService.create("안녕하세요!", user1.getId(), channel.getId());
        Message message2 = messageService.create("반갑습니다!", user2.getId(), channel.getId());

        // 출력 확인
        System.out.println("등록된 유저1: " + user1.getUserName());
        System.out.println("등록된 유저2: " + user2.getUserName());
        System.out.println("등록된 채널: " + channel.getChannelName());
        System.out.println("등록된 메시지1: " + message1.getContent());
        System.out.println("등록된 메시지2: " + message2.getContent());

        // 2. 조회 테스트
        System.out.println("\r\n===== 2. 조회 (Read) 테스트 =====");

        // 단건 조회
        User foundUser = userService.read(user1.getId());
        System.out.println("단건 조회 결과: " + foundUser.getUserName());

        // 다건 조회
        List<User> allUser = userService.readAll();
        System.out.println("전체 사용자 수: " + allUser.size());

        for(User u : allUser) {
            System.out.println("이름: " + u.getUserName() + " (ID: " + u.getId() + ")");
        }

        // 3. 수정 테스트
        System.out.println("\r\n===== 3. 수정 (Update) 테스트 =====");

        // user1 정보 수정
        userService.update(user1.getId(), "soondae", "new@test.com", "5678");

        // 수정 출력 확인
        System.out.println("수정된 이름 확인: " + userService.read(user1.getId()).getUserName());
        System.out.println("수정된 시간(updatedAt): " + userService.read(user1.getId()).getUpdatedAt());

        // 4. 삭제 테스트
        System.out.println("\r\n===== 4. 삭제 (Delete) 테스트 =====");

        // 삭제 전 메시지 개수 확인
        System.out.println("삭제 전 메시지 수: " + messageService.readAll().size());

        // message1("안녕하세요!") 삭제
        messageService.delete(message1.getId());

        if (messageService.read(message1.getId()) == null) {
            System.out.println("메시지가 성공적으로 삭제되었습니다.");
        }

        // 삭제 후 메시지 개수 확인
        List<Message> remainingMessages = messageService.readAll();
        System.out.println("현재 남은 메시지 수: " + remainingMessages.size());

        // 남은 메시지 정보 출력
        System.out.println("남은 메시지 목록");
        for (Message m : remainingMessages) {
            System.out.println("내용: " + m.getContent() + " (보낸 사람 ID: " + m.getSenderId() + ")");
        }
    }
}
