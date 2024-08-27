/*
 *   L.C: 207. Course Schedule
 *
 *   Time Complexity: O(V + E)
 *   Space Complexity: O(V + E), for storing the graph and indegrees.
 *
 *   V is the number of vertices (courses)
 *   E is the number of edges (prerequisites).
 */


class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses]; // Array to track indegree of each course
        Map<Integer, List<Integer>> adjList = new HashMap<>(); // Adjacency list for the graph
        Queue<Integer> queue = new LinkedList<>(); // Queue for courses with no prerequisites
        int completedCourses = 0; // Counter for completed courses

        // Build the graph and fill the indegree array
        for (int[] prerequisite : prerequisites) {
            int prerequisiteCourse = prerequisite[1];
            int currentCourse = prerequisite[0];
            indegree[currentCourse]++;

            adjList
                    .computeIfAbsent(prerequisiteCourse, k -> new ArrayList<>())
                    .add(currentCourse);
        }

        // Enqueue courses with no prerequisites (indegree of 0)
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.add(course);
                completedCourses++;
            }
        }

        // Process the queue
        while (!queue.isEmpty()) {
            int course = queue.poll();

            if (!adjList.containsKey(course)) {
                continue; // If the course has no outgoing edges, continue
            }

            for (int dependentCourse : adjList.get(course)) {
                indegree[dependentCourse]--;

                if (indegree[dependentCourse] == 0) {
                    queue.add(dependentCourse);
                    completedCourses++;
                }
            }
        }
        return completedCourses == numCourses;
    }
}

