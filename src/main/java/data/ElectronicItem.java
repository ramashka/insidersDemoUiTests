package data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ElectronicItem {
    private int id;
    private String title;
    private String binding;
    private String brand;
    private String color;
    private List<String> features = new ArrayList<>();

    public ElectronicItem(int id) {
        this.id = id;
    }

    public static List<String> clearCategories(List<String> categories) {
        List<String> clearCategories = categories.stream().map(c -> c.replaceAll("\\(.*\\)", "").trim())
                .collect(Collectors.toList());
        return clearCategories;
    }

    public void addFeature(String f) {
        features.add(f);
    }

    public boolean checkAllFieldsForText(String text) {
        return (this.title != null && this.title.contains(text))
                || (this.binding != null && this.binding.contains(text))
                || (this.color != null && this.color.contains(text))
                || (this.brand != null && this.brand.contains(text))
                || this.checkFeaturesForText(text);
    }

    private boolean checkFeaturesForText(String text) {
        for (String s : features) {
            if (s.contains(text)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", binding='" + binding + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
