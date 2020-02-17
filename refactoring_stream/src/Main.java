import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Member> members10 = new ArrayList<>();
        members10.add(new Member("M1_10" , 10));
        members10.add(new Member("M2_10" , 14));
        members10.add(new Member("M3_10" , 15));
        members10.add(new Member("M4_10" , 14));
        members10.add(new Member("M5_10" , 17));
        members10.add(new Member("M6_10" , 18));
        members10.add(new Member("M7_10" , 19));
        members10.add(new Member("M8_10" , 0));
        List<Member> members20 = new ArrayList<>();
        members20.add(new Member("M1_20" , 20));
        members20.add(new Member("M2_20" , 24));
        members20.add(new Member("M3_20" , 25));
        members20.add(new Member("M4_20" , 24));
        members20.add(new Member("M5_20" , 27));
        members20.add(new Member("M6_20" , 28));
        members20.add(new Member("M7_20" , 29));
        members20.add(new Member("M8_20" , 21));
        List<Member> members30 = new ArrayList<>();
        members30.add(new Member("M1_30" , 30));
        members30.add(new Member("M2_30" , 34));
        members30.add(new Member("M3_30" , 35));
        members30.add(new Member("M4_30" , 34));
        members30.add(new Member("M5_30" , 37));
        members30.add(new Member("M6_30" , 38));
        members30.add(new Member("M7_30" , 39));
        members30.add(new Member("M8_30" , 31));
        List<MembersGroup> membersGroup = new ArrayList<>();
        membersGroup.add(new MembersGroup("MG1", members10));
        membersGroup.add(new MembersGroup("MG2", members20));
        membersGroup.add(new MembersGroup("MG3", members30));

        Finder finder = new Finder();
        Set<String> groupsNames = finder.findOldMembers(membersGroup,20);
        groupsNames.stream().forEach(System.out::println);
    }
}
