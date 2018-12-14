package electronicapractica10.demo.service;


public interface SecurityService {


    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
