package com.fsjx.user.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Date;

/**
 * 用户实体类
 * Created by lizhen on 2018\5\29 0029.
 */
//@ApiModel()用于类 value–实体类名称;description–描述
@ApiModel(value = "UserEntity",description = "用户参数")
public class UserEntity {
        //@ApiModelProperty()用于方法，字段；name-属性名称（不写的话，默认为字段名）;
        // value–字段说明;example–举例说明;
        //required–是否必填;dataType–重写属性类型(不写默认为，当前字段类型）;
        @ApiModelProperty(value = "用户id",example = "1")
        private Integer id;
        @ApiModelProperty(value = "用户姓名",example = "王红")
        private String username;
        @ApiModelProperty(value = "password",example = "gd*&^^gasd$%$JHKH")
        private String password;
        @ApiModelProperty(value = "phone",example = "136566666")
        private String phone;
        @ApiModelProperty(value = "邮箱",example = "724577807@qq.com")
        private String email;
        private Date created;

        @Override
        public String toString() {
                return "UserEntity{" +
                        "id=" + id +
                        ", username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", phone='" + phone + '\'' +
                        ", email='" + email + '\'' +
                        ", created=" + created +
                        ", updated=" + updated +
                        '}';
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Date getCreated() {
                return created;
        }

        public void setCreated(Date created) {
                this.created = created;
        }

        public Date getUpdated() {
                return updated;
        }

        public void setUpdated(Date updated) {
                this.updated = updated;
        }

        private Date updated;
}
