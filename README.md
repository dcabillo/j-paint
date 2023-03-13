# j-paint

Link to Repo: https://github.com/dcabillo/j-paint.git


Check-in 4:
Patterns: 
1. Abstract Factory pattern. Here we have an IDrawShape interface that creates 3 typed of shapes based on the Factory called. This can all be initiated in the Shape Factory class.

2. Singleton Pattern is implemented in the CollectionHistory Class and in the ShapeCollection Class. These classes can only be instantiated by themselves.

3. Strategy Pattern is implemented by the Shape class and IDrawShape Interface. It allows for draw and all of the baseline shapes, Rectangle, Triangle and ellipse to be treated the same with the same methods.

4.Null Object Pattern is implemented in the command Factory. An null object is executed under certain conditions to avoid undo/redo errors.

5. THIS IS THE NEW PATTERN. Composite Pattern is implemented by the Grouped class, allowing for a grouped set of different shapes to be treated as the same shape.


EXTRA CREDIT:
Made it so that when drawing a shape or selecting a shape, the shape would show as you drag the mouse. the code is in click handler and paint canvas

