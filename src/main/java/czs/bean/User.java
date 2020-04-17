package czs.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    // @id这个注解来对应mongo的_id这个字段
    @Id
    private String _id;

    private Long id;
    private String userName;
    private String passWord;


}



