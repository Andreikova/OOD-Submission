# OOD-Submission
This is an assignment for the class Object Orientated Design. The assignment is to refactor an application called Jabberpoint.
### Changes made
| Problem                                                             | Purposed change                                                     | Why its a good thing                                                                                   |
|---------------------------------------------------------------------|---------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| 1. Recursive possession of the SlideViewComponent and presentation  | Take away presentation access to the SlideViewComponent             | Reduces coupling. The presentation was accessing methods in SlideViewComponent that it did not need to |
| 2. Frame was dependant on the presentation and SlideViewComponent   | restructure how frame, slideViewComponent and presentation interact | Better structure, encapsulation                                                                        |
| 3. key and menu controllers having access to presentation and frame | Add manager class and restructure + change around methods etc       | reduces the controller classes access to other classes                                                 |


### Resit changes made
| Problem | Purposed change | Why it's a good thing   | 
| --------- | --------------- |-------------------------|
|1. Maintainability - Jabberpoint needs to be aware of **(1)** Viewer component, **(2)** Viewer Frame, **(3)** Manager| Add private fields in Jabberpoint to allow it to see the different components. |                    |