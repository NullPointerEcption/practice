-- 1、 查询Student表中的所有记录的Sname、Ssex和Class列。
SELECT Sname,SSEX,CLASS from student;

-- 2、 查询教师所有的单位即不重复的Depart列。
select DISTINCT  DEPART from teacher;

-- 3、 查询Student表的所有记录。
SELECT * from student;

-- 4、 查询Score表中成绩在60到80之间的所有记录。
select * from score where DEGREE BETWEEN  60 and 80;

-- 5、 查询Score表中成绩为85，86或88的记录。
select * from score where DEGREE in (85,86,88);

-- 6、 查询Student表中“95031”班或性别为“女”的同学记录。
SELECT * from student where CLASS = '95031' or SSEX='女';

-- 7、 以Class降序查询Student表的所有记录。
SELECT * FROM student ORDER BY  CLASS DESC ;

-- 8、 以Cno升序、Degree降序查询Score表的所有记录。
SELECT * from score ORDER BY  CNO asc , DEGREE desc;

-- 9、 查询“95031”班的学生人数。
SELECT count(*) as '95031班的学生人数' from student where CLASS='95031';

-- 10、查询Score表中的最高分的学生学号和课程号。
SELECT SNO,CNO,DEGREE from score ORDER BY   DEGREE  DESC LIMIT 1;

SELECT  s1.SNO,s1.CNO,s2.maxDegree from
score s1,(select max(DEGREE) maxDegree from score) s2
where s1.DEGREE = s2.maxDegree;

-- 11、查询‘3-105’号课程的平均分。
SELECT  avg(DEGREE) from score where CNO='3-105';

-- 12、查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。
SELECT  avg(DEGREE) from score where CNO in(
  SELECT CNO from score
  -- where cno like '3%'
  GROUP BY  CNO
  HAVING count(CNO)>=5 and cno like '3%'
);

-- 13、查询最低分大于70，最高分小于90的Sno列。
SELECT  sno from score where  DEGREE between 70 and 90;

-- 14、查询所有学生的Sname、Cno和Degree列。
SELECT std.SNAME,sc.CNO,sc.DEGREE from student std
LEFT JOIN   score sc on std.SNO = sc.SNO;

-- 15、查询所有学生的Sno、Cname和Degree列。
SELECT std.SNAME,cr.CNAME,sc.DEGREE from student std
  LEFT JOIN   score sc on std.SNO = sc.SNO
LEFT JOIN  course cr on sc.CNO = cr.CNO;

-- 16、查询所有学生的Sname、Cname和Degree列。

-- 17、查询“95033”班所选课程的平均分。
SELECT  course.CNAME ,avg(DEGREE) from score
LEFT JOIN course on score.CNO = course.CNO
where SNO in (
  SELECT sno from student where CLASS='95033'
)
GROUP BY  score.CNO ORDER BY  avg(DEGREE) DESC ;

SELECT Cname,AVG(Degree)
FROM Student
INNER JOIN Score ON(Student.Sno=Score.Sno)
INNER JOIN Course ON(Score.Cno=Course.Cno)
WHERE Class='95033'
GROUP BY Course.Cno
ORDER BY Cname;

-- 18、假设使用如下命令建立了一个grade表：
CREATE TABLE grade(low TINYINT,upp TINYINT,rank CHAR(1));
INSERT INTO grade VALUES(90,100,'A');
INSERT INTO grade VALUES(80,89,'B');
INSERT INTO grade VALUES(70,79,'C');
INSERT INTO grade VALUES(60,69,'D');
INSERT INTO grade VALUES(0,59,'E');
-- 现查询所有同学的Sno、Cno和rank列。
SELECT SNO,CNO,
  (case
  when degree>60 and DEGREE< 70 then '及格'
  when degree>70 and DEGREE<90  then '良好'
  when degree>90 then '优秀'
     else '不及格'
  END) rank
  from score;

SELECT  score.*,rank from score
INNER JOIN  grade on score.DEGREE BETWEEN grade.low AND grade.upp;

-- 19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。
SELECT  * from score where
  CNO='3-105'
  and DEGREE>(SELECT DEGREE from score where SNO='109' and CNO = '3-105')
ORDER BY DEGREE;

SELECT s1.Sno,s1.Degree
FROM Score AS s1 INNER JOIN Score AS s2
    ON(s1.Cno=s2.Cno AND s1.Degree>s2.Degree)
WHERE s1.Cno='3-105' AND s2.Sno='109'
ORDER BY s1.DEGREE;

-- 20、查询score中选学一门以上课程的同学中分数为非最高分成绩的记录。
SELECT  * FROM score
GROUP BY  SNO HAVING(count(*)>1) and DEGREE!=max(DEGREE);

SELECT max(DEGREE) FROM score GROUP BY  sno;
SELECT max(DEGREE) FROM score GROUP BY  Cno;

-- 21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。
-- 22、查询和学号为108的同学同年出生的所有学生的Sno、Sname和Sbirthday列。
SELECT S1.SNO,S1.SNAME,S1.SBIRTHDAY
from student s1,student s2
where s2.SNO='108'
and s1.SBIRTHDAY=s2.SBIRTHDAY
and not s1.SNO='108';

-- 23、查询“张旭“教师任课的学生成绩。
SELECT * from score where cno in (
  SELECT cno from course where tno=(
    SELECT tno from teacher where TNAME='张旭' limit 1
  )
)

SELECT Sno,Degree
FROM Score
    INNER JOIN Course ON(Score.Cno=Course.Cno)
    INNER JOIN Teacher ON(Course.Tno=Teacher.Tno)
WHERE Teacher.Tname='张旭';
-- 24、查询选修某课程的同学人数多于5人的教师姓名。
select tname from teacher where tno in(
  select tno from course where cno in(
    select cno from score group by cno having count(*)>5
  )
)
select t1.tname from teacher t1
  inner join course cur on t1.tno = cur.tno
  inner join (select cno from score group by cno having count(*)>5) sub_query1 on sub_query1.cno = cur.cno


-- 25、查询95033班和95031班全体学生的记录。
select * from student where class in('95033','95031')

-- 26、查询存在有85分以上成绩的课程Cno.
select distinct cno from score where  degree>85

-- 27、查询出“计算机系“教师所教课程的成绩表。
select teacher.tname,course.cname,student.sname,score.degree
from score,student ,course, teacher
where score.cno = course.cno
      and		score.sno = student.sno
      and		course.tno = teacher.tno
      and		teacher.depart="计算机系"
order by degree desc;


SELECT Tname,Cname,SName,Degree
FROM teacher Teachers INNER JOIN course Courses
    ON(Teachers.Tno=Courses.Tno) INNER JOIN score Scores
    ON(Courses.Cno=Scores.Cno) INNER JOIN student Students
    ON(Scores.Sno=Students.Sno)
WHERE Teachers.Depart='计算机系'
ORDER BY Degree DESC,Tname,Cname;

-- 28、查询“计算机系”与“电子工程系“不同职称的教师的Tname和Prof。
select * from teacher where depart in ('计算机系','电子工程系')

select * from teacher where depart='计算机系'
                            and prof not in(select prof from teacher where depart='电子工程系')

-- 29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的Cno、Sno和Degree,并按Degree从高到低次序排序。
select * from score where cno='3-105'
                          and degree > (select min(degree) from score where cno='3-245')
order by degree desc;

SELECT Cno,Sno,Degree
FROM score Scores
WHERE Cno='3-105' AND Degree > ANY(
  SELECT Degree
  FROM  score Scores
  WHERE Cno='3-245')
ORDER BY Degree DESC;



-- 30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的Cno、Sno和Degree.
SELECT Cno,Sno,Degree
FROM score Scores
WHERE Cno='3-105' AND Degree > ALL(
  SELECT Degree
  FROM  score Scores
  WHERE Cno='3-245')
ORDER BY Degree DESC;

-- 31、查询所有教师和同学的name、sex和birthday.
-- 32、查询所有“女”教师和“女”同学的name、sex和birthday.
-- 33、查询成绩比该课程平均成绩低的同学的成绩表。
-- 34、查询所有任课教师的Tname和Depart.
-- 35  查询所有未讲课的教师的Tname和Depart.
-- 36、查询至少有2名男生的班号。
-- 37、查询Student表中不姓“王”的同学记录。
-- 38、查询Student表中每个学生的姓名和年龄。
-- 39、查询Student表中最大和最小的Sbirthday日期值。
-- 40、以班号和年龄从大到小的顺序查询Student表中的全部记录。
-- 41、查询“男”教师及其所上的课程。
-- 42、查询最高分同学的Sno、Cno和Degree列。
-- 43、查询和“李军”同性别的所有同学的Sname.
-- 44、查询和“李军”同性别并同班的同学Sname.
-- 45、查询所有选修“计算机导论”课程的“男”同学的成绩表