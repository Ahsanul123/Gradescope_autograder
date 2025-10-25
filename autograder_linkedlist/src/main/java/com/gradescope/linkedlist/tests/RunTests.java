package com.gradescope.linkedlist.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import com.gradescope.jh61b.grader.GradedTestListenerJSON;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LinkedListTest.class
})
public class RunTests {
    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        runner.addListener(new GradedTestListenerJSON());
        Result r = runner.run(RunTests.class);
    }
}

// package com.gradescope.searchSort.tests;

// import org.junit.runner.RunWith;
// import org.junit.runners.Suite;
// import org.junit.runner.JUnitCore;
// import org.junit.runner.Result;
// import com.gradescope.jh61b.grader.GradedTestListenerJSON;
// import com.gradescope.searchSort.tests.BinarySearchTest;
// import com.gradescope.searchSort.tests.InsertionSortTest;



// @RunWith(Suite.class)
// @Suite.SuiteClasses({
//     BinarySearchTest.class,
//     InsertionSortTest.class,
// })
// public class RunTests {
//     public static void main(String[] args) {
//         JUnitCore runner = new JUnitCore();
//         runner.addListener(new GradedTestListenerJSON());
//         Result result = runner.run(RunTests.class);
//     }
// }



// // package com.gradescope.intlist.tests;

// // import org.junit.runner.RunWith;
// // import org.junit.runners.Suite;
// // import org.junit.runner.JUnitCore;
// // import org.junit.runner.Result;
// // // import junit.tests.framework.TestListenerTest
// // import com.gradescope.intlist.tests.IntListTest;
// // import com.gradescope.jh61b.grader.GradedTestListenerJSON;

// // @RunWith(Suite.class)
// // @Suite.SuiteClasses({
// //         IntListTest.class,
// //             IntListPredicates.class,
// //             })
// // public class RunTests {
// //     public static void main(String[] args) {
// //         JUnitCore runner = new JUnitCore();
// //         runner.addListener(new GradedTestListenerJSON());
// //         // runner.addListener(new TestListenerTest());
// //         Result r = runner.run(RunTests.class);
// //     }
// // }
