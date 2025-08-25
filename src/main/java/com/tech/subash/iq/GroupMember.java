package com.tech.subash.iq;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.AccessType;

import java.util.*;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class GroupMember {
    String name;
    boolean isLeader;

    public static void main(String[] args) {
        GroupMember groupMember = new GroupMember("subash", true);
        GroupMember groupMember2 = new GroupMember("ajith", false);
        GroupMember groupMember3 = new GroupMember("kishore", false);
        GroupMember groupMember4 = new GroupMember("monish", false);
        List<GroupMember> list = new ArrayList<>(Arrays.asList(groupMember3, groupMember2, groupMember, groupMember4));

        String user = "monish";

        Comparator<GroupMember> comparator = Comparator
                .comparing((GroupMember g) -> !g.getName().equalsIgnoreCase(user))
                // 2. Leaders next
                .thenComparing((GroupMember g) -> !g.isLeader)
                // 3. Alphabetical order
                .thenComparing((GroupMember g) -> g.getName(), String.CASE_INSENSITIVE_ORDER);

        Collections.sort(list, comparator);

        System.out.println(list);


        List<GroupMember> updated = list.stream()
                .sorted((g1, g2) -> {
                    // If g1 is user
                    if (g1.getName().equalsIgnoreCase(user)) return -1;
                    if (g2.getName().equalsIgnoreCase(user)) return 1;

                    // If g1 is leader (but not user)
                    if (g1.isLeader) return -1;
                    if (g2.isLeader) return 1;

                    // Otherwise sort alphabetically
                    return g1.getName().compareToIgnoreCase(g2.getName());
                })
                .toList();


        System.out.println(updated);

      Stream<GroupMember> groupMemberStream = Stream.concat(
              Stream.concat(
                list.stream().filter(group -> group.name.equalsIgnoreCase(user)),
                list.stream().filter(group -> group.isLeader)
        ),list.stream().filter(
                group -> !group.name.equalsIgnoreCase(user) && !group.isLeader).sorted(Comparator.comparing(GroupMember::getName, String.CASE_INSENSITIVE_ORDER)));
      groupMemberStream.forEach( e -> System.out.println("e  "+ e));

    }

}
