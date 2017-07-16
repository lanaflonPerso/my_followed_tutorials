
package com.wefine.reactive.entity;


import com.wefine.reactive.util.TimestampUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matchcomments")
@TypeAlias("matchcomment")
public class MatchComment {

    // An alternative approach here would be using @DBRef's, but besides
    // not being something fully recommended in MongoDB data design,
    // the MongoDB ReactiveStreams driver does not support them:
    // see https://jira.spring.io/browse/DATAMONGO-1584

    @Id
    private String id = null;
    private String matchId = null;
    private String author = null;
    private String text = null;
    private String timestamp = null;


    public MatchComment() {
        super();
    }

    public MatchComment(final String matchId, final String author, final String text) {
        super();
        this.matchId = matchId;
        this.author = author;
        this.text = text;
        this.timestamp = TimestampUtils.computeISO8601Timestamp();
    }


    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getMatchId() {
        return this.matchId;
    }

    public void setMatchId(final String matchId) {
        this.matchId = matchId;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }



    @Override
    public String toString() {
        return "MatchComment{" +
                "id='" + this.id + '\'' +
                ", matchId='" + this.matchId + '\'' +
                ", author='" + this.author + '\'' +
                ", text='" + this.text + '\'' +
                ", timestamp='" + this.timestamp + '\'' +
                '}';
    }

}
