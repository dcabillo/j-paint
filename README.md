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
