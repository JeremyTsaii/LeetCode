/**
 * Definition for Employee.
 * type Employee struct {
 *     Id int
 *     Importance int
 *     Subordinates []int
 * }
 */
​
func getImportance(employees []*Employee, id int) int {
    m := make(map[int]int)
    for i, emp := range employees {
        m[(*emp).Id] = i
    }
    return recurse(employees, id, m)
}
​
func recurse(employees []*Employee, id int, m map[int]int) int {
    person := (*employees[m[id]])
    sum := person.Importance
    for _, sub := range person.Subordinates {
        sum += getImportance(employees, sub)
    }
    return sum
}
​
