package appagency.service;

public interface ProfileService {
    void deleteUser(String login);

    void editUser(String field, String value, String login);
}
