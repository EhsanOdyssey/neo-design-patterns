package neo.ehsanodyssey.patterns.adapter;

import neo.ehsanodyssey.patterns.adapter.adapters.SquarePegAdapter;
import neo.ehsanodyssey.patterns.adapter.round.RoundHole;
import neo.ehsanodyssey.patterns.adapter.round.RoundPeg;
import neo.ehsanodyssey.patterns.adapter.square.SquarePeg;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Tue 23 Nov 2021
 */
public class DemoAdapter {

    /**
     * Also known as: Wrapper
     * Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
     * An adapter wraps one of the objects to hide the complexity of conversion happening behind the scenes.
     * The wrapped object isn’t even aware of the adapter.
     * For example, you can wrap an object that operates in meters and kilometers with an adapter that converts
     * all the data to imperial units such as feet and miles.
     * Adapters can not only convert data into various formats but can also help objects with different interfaces collaborate.
     */

    public static void main(String[] args) {
        // Round fits round, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile.

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}
