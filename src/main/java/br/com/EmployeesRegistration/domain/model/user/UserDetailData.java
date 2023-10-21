package br.com.EmployeesRegistration.domain.model.user;

public record UserDetailData(Long id , String name , String login ,
        String password , String telephone ,String gender) {


    public UserDetailData(UserModel user){
        this(user.getId() , user.getName(), user.getLogin(),
                user.getPassword() ,user.getTelephone() , user.getGender()) ;

    }
}




