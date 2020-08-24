package cn.bdqn.beans.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class LoginUser {
    /**
     * 用户
     */
    private User user;

    /**
     * 用户token验证(header的键名)
     */
    private String token;
}
