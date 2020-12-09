package org.example.dao.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "match_stats", schema = "AustralianFootball")
public class Match_StatsEntity {

    @EmbeddedId()
    private key key;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Embeddable
    public static class key implements java.io.Serializable{
        @Column(name="mid")
        private String mid;

        @Column(name="pid")
        private int pid;
    }

    @ManyToOne
    @JoinColumn(name="tid")
    private TeamsEntity teams;

    @Column(name ="loc")
    private String loc;

    @Column(name = "KI")
    private int ki;

    @Column(name = "MK")
    private int mk;

    @Column(name = "HB")
    private int mb;

    @Column(name = "DI")
    private int di;

    @Column(name = "GL")
    private int gl;

    @Column(name = "BH")
    private int bh;

    @Column(name = "HO")
    private int ho;

    @Column(name = "TK")
    private int tk;

    @Column(name = "RB")
    private int rb;

    @Column(name = "IF")
    private int lf;

    @Column(name = "CL")
    private int cl;

    @Column(name = "CG")
    private int cg;

    @Column(name = "FF")
    private int ff;

    @Column(name = "FA")
    private int fa;

    @Column(name = "BR")
    private int br;

    @Column(name = "CP")
    private int cp;

    @Column(name = "UP")
    private int up;

    @Column(name = "CM")
    private int cm;

    @Column(name = "MI")
    private int mi;

    @Column(name = "1P")
    private String lp;

    @Column(name = "BO")
    private int bo;

    @Column(name = "GA")
    private int ga;

    @Column(name = "PP")
    private String pp;
}
