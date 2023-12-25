package com.example.careregistrrysprinboot.ServiceImplementation;


import com.example.careregistrrysprinboot.Repository.UserRepository;
import com.example.careregistrrysprinboot.Service.UserService;
import com.example.careregistrrysprinboot.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
      private  BCryptPasswordEncoder bcryptPasswordEncoder;



    @Override
    public User saveUser(User user) {
        String password = bcryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        User newUser = userRepository.save(user);
        return newUser;
    }



    @Override
    public void removeSuccessMessage() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        if (attr != null) {
            HttpSession session = attr.getRequest().getSession();
            if (session != null) {
                session.removeAttribute("msg");
            }
        }
    }





}
