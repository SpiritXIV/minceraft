# This tps them back too the backroomstwo with there exact pos
execute as @a[nbt={Dimension:"shit:backroomsone"}] at @s if block ~ ~-1 ~ shit:backrooms_concrete_floor_teleport run execute in shit:backroomstwo run tp ~ 20 ~
playsound shit:fall_into_backrooms master @a[nbt={Dimension:"shit:backroomstwo"}] ~ ~ ~ 1 1
