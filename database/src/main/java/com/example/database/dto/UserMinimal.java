package com.example.database.dto;

import lombok.Data;

@Data

public class UserMinimal {
	
	private Integer id;
	private String firstName;
	private String secondName;


    public UserMinimal(Integer id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public UserMinimal() {
    }

    public static UserMinimalBuilder builder() {
        return new UserMinimalBuilder();
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserMinimal)) return false;
        final UserMinimal other = (UserMinimal) o;
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
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserMinimal;
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
        return result;
    }

    public String toString() {
        return "UserMinimal(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", secondName=" + this.getSecondName() + ")";
    }

    public static class UserMinimalBuilder {
        private Integer id;
        private String firstName;
        private String secondName;

        UserMinimalBuilder() {
        }

        public UserMinimalBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public UserMinimalBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserMinimalBuilder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserMinimal build() {
            return new UserMinimal(id, firstName, secondName);
        }

        public String toString() {
            return "UserMinimal.UserMinimalBuilder(id=" + this.id + ", firstName=" + this.firstName + ", secondName=" + this.secondName + ")";
        }
    }
}
