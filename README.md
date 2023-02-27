# j-paint

Link to Repo: https://github.com/dcabillo/j-paint.git

Check-in 1: 
rectangles appear and undo redo also work. When you add more rectangles after undoing an action you cannot redo that action. This was a purposeful design decision to avoid having 2 stacks and redoing work that could mess up new work. The code runs, but I am getting warnings from intellij on the add event listener file. 

Check-in 2: 
ran out of time for this one. implemented everything except for the move functionality. I have the groundwork for it coded but its messy and I started to 
rush towards the end. 
Design patterns : Abstract Factory. ClickHandler calls getShape in ShapeSwitch to then create a IDraw shape which becomes an IShape into the ShapeCollection. 

Observer pattern is implemented by the Click handler and notifies the PaintCanvas to change shape collection

Needed more time to analyze, identify, and implement more patterns

Check-in 3: 
Patterns: 
1. Adapter pattern implemented in the Shape class. I think there is an arguement to be made that the adapter pattern is present for all shape types due to the draw method. i.e. using a custom method to call third party drawing functionality. It is especially present with the Triangle class because the code allows for the same inputs to be pushed into REC, TRI, and ELLIPSE, even though the third party draw function for triangle takes in 2 arrays, rather than the standard corners my code takes in. 
2. Singleton Design Pattern is implemented in the CollectionHistory Class and in the ShapeCollection Class. These classes can only be instantiated by themselves.
3. Abstract Factory pattern. Here we have an IDrawShape interface that creates 3 typed of shapes based on the Factory called. This can all be initiated in the Shape Factory class.

