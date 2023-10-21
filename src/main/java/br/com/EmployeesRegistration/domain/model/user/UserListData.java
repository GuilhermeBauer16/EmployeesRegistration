package br.com.EmployeesRegistration.domain.model.user;

public record UserListData(Long id ,String name, String gender , String telephone , String login) {

    public UserListData(UserModel userModel){
        this (userModel.getId(), userModel.getName(),userModel.getGender(), userModel.getTelephone(),userModel.getLogin());
    }
}
