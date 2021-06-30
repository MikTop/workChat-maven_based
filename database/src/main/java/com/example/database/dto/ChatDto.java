package com.example.database.dto;

import java.util.List;

public class ChatDto {
	
	List<UserMinimal> chatsMembers;
	String chatName;
	Integer chatId;

    public ChatDto(List<UserMinimal> chatsMembers, String chatName, Integer chatId) {
        this.chatsMembers = chatsMembers;
        this.chatName = chatName;
        this.chatId = chatId;
    }

    public ChatDto() {
    }

    public static ChatDtoBuilder builder() {
        return new ChatDtoBuilder();
    }

    public List<UserMinimal> getChatsMembers() {
        return this.chatsMembers;
    }

    public String getChatName() {
        return this.chatName;
    }

    public Integer getChatId() {
        return this.chatId;
    }

    public void setChatsMembers(List<UserMinimal> chatsMembers) {
        this.chatsMembers = chatsMembers;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ChatDto)) return false;
        final ChatDto other = (ChatDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$chatsMembers = this.getChatsMembers();
        final Object other$chatsMembers = other.getChatsMembers();
        if (this$chatsMembers == null ? other$chatsMembers != null : !this$chatsMembers.equals(other$chatsMembers))
            return false;
        final Object this$chatName = this.getChatName();
        final Object other$chatName = other.getChatName();
        if (this$chatName == null ? other$chatName != null : !this$chatName.equals(other$chatName)) return false;
        final Object this$chatId = this.getChatId();
        final Object other$chatId = other.getChatId();
        if (this$chatId == null ? other$chatId != null : !this$chatId.equals(other$chatId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ChatDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $chatsMembers = this.getChatsMembers();
        result = result * PRIME + ($chatsMembers == null ? 43 : $chatsMembers.hashCode());
        final Object $chatName = this.getChatName();
        result = result * PRIME + ($chatName == null ? 43 : $chatName.hashCode());
        final Object $chatId = this.getChatId();
        result = result * PRIME + ($chatId == null ? 43 : $chatId.hashCode());
        return result;
    }

    public String toString() {
        return "ChatDto(chatsMembers=" + this.getChatsMembers() + ", chatName=" + this.getChatName() + ", chatId=" + this.getChatId() + ")";
    }

    public static class ChatDtoBuilder {
        private List<UserMinimal> chatsMembers;
        private String chatName;
        private Integer chatId;

        ChatDtoBuilder() {
        }

        public ChatDtoBuilder chatsMembers(List<UserMinimal> chatsMembers) {
            this.chatsMembers = chatsMembers;
            return this;
        }

        public ChatDtoBuilder chatName(String chatName) {
            this.chatName = chatName;
            return this;
        }

        public ChatDtoBuilder chatId(Integer chatId) {
            this.chatId = chatId;
            return this;
        }

        public ChatDto build() {
            return new ChatDto(chatsMembers, chatName, chatId);
        }

        public String toString() {
            return "ChatDto.ChatDtoBuilder(chatsMembers=" + this.chatsMembers + ", chatName=" + this.chatName + ", chatId=" + this.chatId + ")";
        }
    }
}
