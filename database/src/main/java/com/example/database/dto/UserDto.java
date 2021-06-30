package com.example.database.dto;

import com.example.database.entity.Role;

import java.time.LocalDate;

public class UserDto {
	
	private Integer id;
	private String firstName;
	private String secondName;
	private String email;
	private String image;
	private LocalDate birthday;
	private Role role;

    public UserDto(Integer id, String firstName, String secondName, String email, String image, LocalDate birthday, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.image = image;
        this.birthday = birthday;
        this.role = role;
    }

    public UserDto() {
    }

    public static UserDtoBuilder builder() {
        return new UserDtoBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getImage() {
        return this.image;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public Role getRole() {
        return this.role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDto)) return false;
        final UserDto other = (UserDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$secondName = this.getSecondName();
        final Object other$secondName = other.getSecondName();
        if (this$secondName == null ? other$secondName != null : !this$secondName.equals(other$secondName))
            return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$image = this.getImage();
        final Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) return false;
        final Object this$birthday = this.getBirthday();
        final Object other$birthday = other.getBirthday();
        if (this$birthday == null ? other$birthday != null : !this$birthday.equals(other$birthday)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $secondName = this.getSecondName();
        result = result * PRIME + ($secondName == null ? 43 : $secondName.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $image = this.getImage();
        result = result * PRIME + ($image == null ? 43 : $image.hashCode());
        final Object $birthday = this.getBirthday();
        result = result * PRIME + ($birthday == null ? 43 : $birthday.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        return result;
    }

    public String toString() {
        return "UserDto(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", secondName=" + this.getSecondName() + ", email=" + this.getEmail() + ", image=" + this.getImage() + ", birthday=" + this.getBirthday() + ", role=" + this.getRole() + ")";
    }

    public static class UserDtoBuilder {
        private Integer id;
        private String firstName;
        private String secondName;
        private String email;
        private String image;
        private LocalDate birthday;
        private Role role;

        UserDtoBuilder() {
        }

        public UserDtoBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDtoBuilder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDtoBuilder image(String image) {
            this.image = image;
            return this;
        }

        public UserDtoBuilder birthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserDtoBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public UserDto build() {
            return new UserDto(id, firstName, secondName, email, image, birthday, role);
        }

        public String toString() {
            return "UserDto.UserDtoBuilder(id=" + this.id + ", firstName=" + this.firstName + ", secondName=" + this.secondName + ", email=" + this.email + ", image=" + this.image + ", birthday=" + this.birthday + ", role=" + this.role + ")";
        }
    }
}
