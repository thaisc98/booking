package hotel.booking.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Country {

    @Id
    @Column(name = "key")
    private String key;

    @Column(name = "name")
    private String name;

}
