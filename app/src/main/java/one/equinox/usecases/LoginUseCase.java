//package one.equinox.usecases;
//
//import android.content.SharedPreferences;
//
//
//
//
//public class LoginUseCase extends UseCase<User> {
//    SharedPreferences preferences;
//    UserService userService;
//    private static final String USER_TOKEN = "user_token";
//
//    @Override
//    protected User execute() throws Exception {
//        Response<User> userResponse =  userService.login(username, password).execute();
//        if(userResponse.isSuccess()){
//            User user = userResponse.body();
//            preferences.edit().putString(USER_TOKEN, user.getToken()).commit();
//        } else {
//            //TODO login error
//        }
//    }
//}
