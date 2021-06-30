package com.example.database.dto;

import jakarta.servlet.http.Part;

public class UserCreate {
	
		
		
		private String firstName;
		private String secondName;
		private String email;
		private String password;
		private Part image;
		private String birthday;
		private String role;

    public UserCreate(String firstName, String secondName, String email, String password, Part image, String birthday, String role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.image = image;
        this.birthday = birthday;
        this.role = role;
    }

    public UserCreate() {
    }

    public static UserCreateBuilder builder() {
        return new UserCreateBuilder();
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

    public String getPassword() {
        return this.password;
    }

    public Part getImage() {
        return this.image;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getRole() {
        return this.role;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserCreate)) return false;
        final UserCreate other = (UserCreate) o;
        if (!other.canEqual((Object) this)) return false;
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
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
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
        return other instanceof UserCreate;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $secondName = this.getSecondName();
        result = result * PRIME + ($secondName == null ? 43 : $secondName.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $image = this.getImage();
        result = result * PRIME + ($image == null ? 43 : $image.hashCode());
        final Object $birthday = this.getBirthday();
        result = result * PRIME + ($birthday == null ? 43 : $birthday.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        return result;
    }

    public String toString() {
        return "UserCreate(firstName=" + this.getFirstName() + ", secondName=" + this.getSecondName() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", image=" + this.getImage() + ", birthday=" + this.getBirthday() + ", role=" + this.getRole() + ")";
    }

    public static class UserCreateBuilder {
        private String firstName;
        private String secondName;
        private String email;
        private String password;
        private Part image;
        private String birthday;
        private String role;

        UserCreateBuilder() {
        }

        public UserCreateBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserCreateBuilder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserCreateBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserCreateBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserCreateBuilder image(Part image) {
            this.image = image;
            return this;
        }

        public UserCreateBuilder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserCreateBuilder role(String role) {
            this.role = role;
            return this;
        }

        public UserCreate build() {
            return new UserCreate(firstName, secondName, email, password, image, birthday, role);
        }

        public String toString() {
            return "UserCreate.UserCreateBuilder(firstName=" + this.firstName + ", secondName=" + this.secondName + ", email=" + this.email + ", password=" + this.password + ", image=" + this.image + ", birthday=" + this.birthday + ", role=" + this.role + ")";
        }
    }
}

