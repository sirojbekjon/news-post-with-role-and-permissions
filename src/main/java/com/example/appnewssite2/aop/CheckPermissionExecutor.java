package com.example.appnewssite2.aop;

import com.example.appnewssite2.entity.User;
import com.example.appnewssite2.exceptions.ForbiddenException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckPermissionExecutor {

    @Before(value = "@annotation(huquqniTekshirish)")
    public void checkUserPermissionMyMethod(HuquqniTekshirish huquqniTekshirish){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean exist = false;
        for (GrantedAuthority authority : user.getAuthorities()){
            if (authority.getAuthority().equals(huquqniTekshirish.huquq())){
                exist = true;
                break;
            }
        }
        if (!exist){
            throw new ForbiddenException(huquqniTekshirish.huquq(), "Ruxsat yo'q");
        }

    }


}
