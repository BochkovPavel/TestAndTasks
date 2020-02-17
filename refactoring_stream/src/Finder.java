import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finder {
    /**
     * Поиск групп людей старше определенного возраста.
     *
     * @param groups группы
     * @param targetAge возраст для поиска
     * @return список имен групп из списка групп старше возраста targetAge
     */
    public Set<String> findOldMembers(List<MembersGroup> groups, int targetAge) {
        Set<String> groupsNames = new HashSet<>();

        groups.stream()
                .filter(membersGroup -> membersGroup.getMembers().stream()
                        .anyMatch(member -> member.getAge() > targetAge))
                .forEach(membersGroup -> groupsNames.add(membersGroup.getGroupName()));

        return groupsNames;
    }

}
