package Model;

public class Player {
    int player_id;
    String nickname;
    String player_email;

    public Player() {}

    public Player(String nickname, String player_email)
    {
        this.nickname = nickname;
        this.player_email = player_email;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setPlayer_name(String nickname) {
        this.nickname = nickname;
    }

    public String getPlayer_email() {
        return player_email;
    }

    public void setPlayer_email(String player_email) {
        this.player_email = player_email;
    }

    @Override
    public String toString()
    {
        return "players [player_id=" + player_id + ", nickname=" + nickname + ", player_email=" + player_email + "]";
    }
}
