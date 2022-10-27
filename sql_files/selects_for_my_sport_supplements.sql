use sport_supplements;

-- -- 1
-- SELECT distinct info as Competition_info, YEAR(date_of_event) as Date_in_year, COUNT(date_of_event) as Count
-- FROM competition WHERE YEAR(date_of_event) >= 2018 GROUP BY info,YEAR(date_of_event);

-- -- 2
-- SELECT kind_of_sport, AVG(height) as avg_height, AVG(weight) as avg_weight FROM sportsman GROUP BY kind_of_sport;

-- -- 3
-- SELECT sportsman.id, kind_of_sport, place_id FROM sportsman 
-- iNNER JOIN competition on sportsman.id = competition.id;

-- -- 4
-- SELECT description FROM schedule where (YEAR(start_dieting) >= 2017 AND MONTH(start_dieting) >= 1) 
-- and (YEAR(end_dieting) <= 2019 AND MONTH(end_dieting) >= 1) ORDER BY end_dieting;

-- -- 5
-- SELECT doctor.name, COUNT(sportsman.doctor_id) as count_of_clients FROM doctor 
-- INNER JOIN sportsman ON sportsman.doctor_id = doctor.id GROUP BY sportsman.doctor_id;

-- -- 6
-- SELECT schedule_id, COUNT(schedule_id) as schedule_count, AVG(weight) as average_weight FROM sportsman 
-- GROUP BY schedule_id ORDER BY AVG(weight) DESC;

-- -- 7
-- SELECT name, calories as count_of_calories FROM dish 
-- ORDER BY calories DESC;

-- -- 8

-- SELECT kind_of_sport, COUNT(kind_of_sport) as count_of_players_in_this_sport FROM sportsman 
-- GROUP BY kind_of_sport ORDER BY count_of_players_in_this_sport DESC;

-- -- 9
-- SELECT name, calories AS count_of_calories FROM supplement 
-- ORDER BY calories DESC LIMIT 1;
-- how to do it with max()

-- SELECT name, MAX(calories) AS count_of_calories FROM supplement 
-- GROUP BY calories;

-- 10
SELECT coach.name AS name, coach.surname AS surname FROM coach 
INNER JOIN sportsman ON sportsman.coach_id = coach.id HAVING COUNT(sportsman.coach_id) =
(SELECT MAX(t.num) FROM (SELECT COUNT(coach_id) AS num FROM sportsman GROUP BY num) AS t);


-- (SELECT COUNT(coach_id) as c FROM sportsman GROUP BY c ORDER BY c DESC LIMIT 1);

   

