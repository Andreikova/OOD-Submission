# OOD-Submission

### Changes made
| Problem                                                             | Purposed change                                                     | Why its a good thing                                                                                   |
|---------------------------------------------------------------------|---------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| 1. Recursive possession of the SlideViewComponent and presentation  | Take away presentation access to the SlideViewComponent             | Reduces coupling. The presentation was accessing methods in SlideViewComponent that it did not need to |
| 2. Frame was dependant on the presentation and SlideViewComponent   | restructure how frame, slideViewComponent and presentation interact | Better structure, encapsulation                                                                        |
| 3. key and menu controllers having access to presentation and frame | Add manager class and restructure + change around methods etc       | reduces the controller classes access to other classes                                                 |