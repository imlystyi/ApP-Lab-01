/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "Item.java" file */

package Task05;

public record Item(double weight, double volume) {
    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public double volume() {
        return this.volume;
    }
}
