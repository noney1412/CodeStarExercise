```math



P_{3} = P_{2} \cdot ( \frac{a_{2}(a_{3}+b_{3}+c_{3})}{b_{3} \cdot c_{3}}) \\ {} \\

\text {แต่เราจะแก้สมการอีกรอบให้อยู่ในรูปของ Function} \\ {} \\
\text {สมมติ ตอนนี้มันลูปวนมาที่ F2} \\ {} \\

F1 \cdot \cdot \cdot \cdot \cdot \cdot \text { M = [ 6 0 2 ] จะคืนคำตอบ 540 ที่เป็นของตัวถัดไป } \\ {} \\
F2 \cdot \cdot \cdot \cdot \cdot \cdot \text { M = [ 5 1 3 ] จะคืน 3150 ที่เป็นคำตอบของ F3 } \\ {} \\
F3 \cdot \cdot \cdot \cdot \cdot \cdot \text { M = [ 4 2 4 ] คืน F4 ไปเรื่อย ๆ ๆ แล้ว } \\ {} \\

\text{มันจะจบที่ M = [ 1 5 7 ] สมการมันก็จะเป็น ...}  \\ {} \\

f_{2}(a,b,c) = f_{1}(a+1,b-1,c-1) \cdot H(a-1,b+1,c+1) \\ {} \\

\text{ลองแทนค่าอีกทีจะได้เป็น}  \\ {} \\

f_{2}(5,1,3) = f_{1}(6,0,2) \cdot H(4,2,4) \\ {} \\
f_{2}(5,1,3) = 504 \cdot H(4,2,4) \\ {} \\
\text{ที่ } f_{1} \text{คืน 504 ก็เพราะว่า } f_1 จะคืนค่าของตัวถัดไปไง \text{ ส่วน } f_{2} ก็จะคืน \text{ 3150 } \\ 
\text{ที่เป็นคำตอบของ } f_3 \text { ไปเรื่อย ๆ ๆ จนจบ เพราะครึ่งสองมันเป็น [ 0 6 8 ] } \\ 
\text{ครึ่งแรกก็ต้องจบที่ [ 1 5 7 ] นั่นเอง } \\ 
 




```
