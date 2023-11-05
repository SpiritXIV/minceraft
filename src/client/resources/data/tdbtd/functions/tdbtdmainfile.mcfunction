execute at @a[scores={xp_level=30..}, nbt={SelectedItem:{id:"tdbtd:dimented_serpent"}},limit=2] run tag @e[distance=..1,type=minecraft:arrow,limit=1] add sculkarrow
execute as @a[scores={xp_level=30..}, nbt={SelectedItem:{id:"tdbtd:dimented_serpent"}},limit=2] if entity @e[tag=sculkarrow] run function tdbtd:sonic_boom_shoot
execute as @a[scores={xp_level=30..}, nbt={SelectedItem:{id:"tdbtd:dimented_serpent"}},limit=2] if entity @e[tag=sculkarrow] run function tdbtd:sonic_boom_activate
execute at @a[scores={xp_level=10..}, nbt={SelectedItem:{id:"tdbtd:dimented_thorn"}},limit=2] run tag @e[distance=..1,type=minecraft:arrow,limit=1] add thorn
execute as @a[scores={xp_level=10..}, nbt={SelectedItem:{id:"tdbtd:dimented_thorn"}},limit=2] if entity @e[tag=thorn] run function tdbtd:sonic_shriek_shoot
execute as @a[scores={xp_level=10..}, nbt={SelectedItem:{id:"tdbtd:dimented_thorn"}},limit=2] if entity @e[tag=thorn] run function tdbtd:sonic_shriek_activate

execute as @a[nbt={ActiveEffects:[{Id:35}]}] run stopsound @a[nbt={ActiveEffects:[{Id:35}]}]
execute at @e[nbt={ActiveEffects:[{Id:34}]}] run particle minecraft:sculk_soul ^ ^ ^ 0 1 0 0.1 1 force
execute at @e[nbt={ActiveEffects:[{Id:35}]}] run particle minecraft:sculk_charge_pop ^ ^ ^ 0 1 0 0.05 4 force
execute at @e[nbt={ActiveEffects:[{Id:34}]},nbt={ActiveEffects:[{Id:35}]},nbt={ActiveEffects:[{Id:33}]}] run particle minecraft:sculk_soul ^ ^ ^ 0 1 0 0.1 10 force
execute at @e[nbt={ActiveEffects:[{Id:34}]},nbt={ActiveEffects:[{Id:35}]},nbt={ActiveEffects:[{Id:33}]}] run particle minecraft:sculk_charge_pop ^ ^ ^ 0 1 0 0.1 10 force
execute at @e[nbt={ActiveEffects:[{Id:34}]},nbt={ActiveEffects:[{Id:35}]},nbt={ActiveEffects:[{Id:33}]}] run particle minecraft:soul_fire_flame ^ ^ ^ 0 1 0 0.1 2 force
kill @e[tag=sculkarrow]
kill @e[tag=thorn]