package Chapter13_Lambda_and_Stream.innerclass.optional;

import java.util.ArrayList;

public class UserInfoTest {
    public static void main(String[] args) {
        ArrayList<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(12345, "Liam"));
        userInfoList.add(new UserInfo(12346, "Silva"));
        userInfoList.add(new UserInfo(12347, "Sonny"));

        UserInfo userInfo = getUserInfoByID(12345, userInfoList);
        System.out.println(userInfo.getName());
    }

    public static UserInfo getUserInfoByID(int ID, ArrayList<UserInfo> list) {
        for (UserInfo userInfo : list) {
            if (ID == userInfo.getID())
                return userInfo;
        }
        return null;
    }
}
