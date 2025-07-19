package Chapter13_Lambda_and_Stream.innerclass.stream;

import java.util.ArrayList;
import java.util.List;

class UserInfo {
    private String name;
    private int age;

    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class UserInfoMapTest {
    public static void main(String[] args) {
        UserInfo userKim = new UserInfo("김민재", 30);
        UserInfo userLee = new UserInfo("이승우", 26);
        UserInfo userSong = new UserInfo("송민규", 25);

        List<UserInfo> userInfoList = new ArrayList<>();

        userInfoList.add(userKim);
        userInfoList.add(userLee);
        userInfoList.add(userSong);

        // filter와 map 연산으로 30세 이상인 사용자의 이름 추출

        userInfoList.stream()
                .filter(user -> user.getAge() >= 30)  // 30세 이상 사용자 필터링
                .map(UserInfo::getName)
                .forEach(s -> System.out.println(s));
    }
}
