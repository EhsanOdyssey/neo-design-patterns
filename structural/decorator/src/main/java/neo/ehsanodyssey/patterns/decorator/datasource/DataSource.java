package neo.ehsanodyssey.patterns.decorator.datasource;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public interface DataSource {
    void writeData(String data);
    String readData();
}
