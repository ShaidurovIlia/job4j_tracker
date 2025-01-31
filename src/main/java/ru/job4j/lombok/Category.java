package ru.job4j.lombok;

import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Category {
    @EqualsAndHashCode.Include
    @Getter
    @NonNull
    private int id;
    @Getter
    @Setter
    private String name;
}
