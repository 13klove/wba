package web.boostcourse.api.wba.displayInfoImage.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DisplayInfoImage {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;



}
