package DAO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "test", catalog = "d79rks0b7v2fuu")
public class UserEntity {
    private int id;
    private long userId;
    private long chatId;
    private String username;
    private Integer pidorCount;
    private Integer prettyCount;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "chat_id", nullable = false)
    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "pidor_count", nullable = false)
    public int getPidorCount() {
        return pidorCount;
    }

    public void setPidorCount(int countpidor) {
        this.pidorCount = countpidor;
    }

    @Basic
    @Column(name = "pretty_count", nullable = false)
    public Integer getPrettyCount() {
        return prettyCount;
    }

    public void setPrettyCount(Integer countcool) {
        this.prettyCount = countcool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                userId == that.userId &&
                chatId == that.chatId &&
                pidorCount.equals(that.pidorCount) &&
                Objects.equals(username, that.username) &&
                Objects.equals(prettyCount, that.prettyCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, chatId, username, pidorCount, prettyCount);
    }
}
