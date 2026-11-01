.method protected Y2([Lluaj/LuaValue;Lluaj/Varargs;Z)Lluaj/Varargs;
    .locals 39

    .line 1
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    move/from16 v4, p3

    const-string v5, ")"

    sget-object v6, Lluaj/LuaValue;->f1676f:Lluaj/LuaValue;

    iget-object v7, v1, Lluaj/LuaClosure;->R:Lluaj/h;

    iget-object v8, v7, Lluaj/h;->f1724b:[I

    iget-object v9, v7, Lluaj/h;->f1723a:[Lluaj/LuaValue;

    iget-object v10, v1, Lluaj/LuaClosure;->S:[Lluaj/i;

    iput-object v3, v1, Lluaj/LuaClosure;->V:Lluaj/Varargs;

    array-length v11, v2

    iget-object v7, v7, Lluaj/h;->f1725c:[Lluaj/h;

    array-length v7, v7

    if-lez v7, :cond_0

    new-array v7, v11, [Lluaj/i;

    goto :goto_0

    :cond_0
    const/4 v7, 0x0

    :goto_0
    iget-object v13, v1, Lluaj/LuaClosure;->T:Lluaj/Globals;

    if-eqz v13, :cond_1

    iget-object v14, v13, Lluaj/Globals;->i0:Lluaj/lib/DebugLib;

    goto :goto_1

    :cond_1
    const/4 v14, 0x0

    :goto_1
    if-eqz v14, :cond_2

    invoke-virtual {v14, v1, v3, v2, v4}, Lluaj/lib/DebugLib;->i3(Lluaj/LuaClosure;Lluaj/Varargs;[Lluaj/LuaValue;Z)V

    :cond_2
    const/4 v15, 0x1

    :try_start_0
    sget v16, Lluaj/LuaClosure;->Y:I

    add-int/lit8 v16, v16, 0x1

    sput v16, Lluaj/LuaClosure;->Y:I

    sget-object v16, Lluaj/LuaValue;->f1673c:Lluaj/LuaValue;

    sget-object v17, Lluaj/LuaValue;->f1674d:Lluaj/LuaBoolean;

    sget-object v18, Lluaj/LuaValue;->f1675e:Lluaj/LuaBoolean;

    sget-object v3, Lluaj/LuaValue;->f1677g:Lluaj/LuaNumber;

    iget-object v15, v1, Lluaj/LuaClosure;->U:Ljava/lang/String;

    iget-object v12, v1, Lluaj/LuaClosure;->R:Lluaj/h;

    iget-object v12, v12, Lluaj/h;->f1725c:[Lluaj/h;

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v21
    :try_end_0
    .catch Lluaj/d; {:try_start_0 .. :try_end_0} :catch_3a
    .catch Ljava/lang/StackOverflowError; {:try_start_0 .. :try_end_0} :catch_39
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_38
    .catchall {:try_start_0 .. :try_end_0} :catchall_12

    move-object/from16 v25, v6

    move/from16 v24, v11

    const/4 v4, 0x0

    const/4 v11, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    const/16 v26, 0x0

    const/16 v27, 0x0

    :goto_2
    :try_start_1
    invoke-virtual/range {v21 .. v21}, Ljava/lang/Thread;->isInterrupted()Z

    move-result v28
    :try_end_1
    .catch Lluaj/d; {:try_start_1 .. :try_end_1} :catch_36
    .catch Ljava/lang/StackOverflowError; {:try_start_1 .. :try_end_1} :catch_35
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_34
    .catchall {:try_start_1 .. :try_end_1} :catchall_11

    if-nez v28, :cond_6a

    if-eqz v14, :cond_3

    :try_start_2
    invoke-virtual {v14, v11, v6, v4}, Lluaj/lib/DebugLib;->k3(ILluaj/Varargs;I)V
    :try_end_2
    .catch Lluaj/d; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/StackOverflowError; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_5

    :catchall_0
    move-exception v0

    move-object v2, v0

    move-object/from16 v28, v7

    move v3, v11

    move-object v13, v14

    goto/16 :goto_96

    :catch_0
    move-exception v0

    move-object v2, v0

    move-object/from16 v28, v7

    move-object v13, v14

    goto/16 :goto_97

    :catch_1
    move-exception v0

    move-object v2, v0

    move-object v4, v5

    move-object/from16 v28, v7

    move-object v13, v14

    goto/16 :goto_98

    :catch_2
    move-exception v0

    move-object v5, v0

    move-object/from16 v28, v7

    move v4, v11

    move-object v13, v14

    move/from16 v3, v22

    move/from16 v22, v23

    :goto_3
    move/from16 v6, v26

    :goto_4
    move/from16 v11, v27

    goto/16 :goto_9a

    :cond_3
    :goto_5
    :try_start_3
    iput v11, v1, Lluaj/LuaClosure;->W:I
    :try_end_3
    .catch Lluaj/d; {:try_start_3 .. :try_end_3} :catch_36
    .catch Ljava/lang/StackOverflowError; {:try_start_3 .. :try_end_3} :catch_35
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_34
    .catchall {:try_start_3 .. :try_end_3} :catchall_11

    move-object/from16 v28, v14

    :try_start_4
    aget v14, v8, v11
    :try_end_4
    .catch Lluaj/d; {:try_start_4 .. :try_end_4} :catch_33
    .catch Ljava/lang/StackOverflowError; {:try_start_4 .. :try_end_4} :catch_32
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_4} :catch_23
    .catchall {:try_start_4 .. :try_end_4} :catchall_f

    move-object/from16 v29, v3

    shr-int/lit8 v3, v14, 0x6

    move-object/from16 v30, v5

    const/16 v5, 0xff

    and-int/2addr v3, v5

    and-int/lit8 v5, v14, 0x3f

    move-object/from16 v31, v6

    const-string v6, " ("

    move-object/from16 v22, v6

    const-string v6, "Null from "

    const v23, 0x7fc000

    const v32, 0x1ffff

    move-object/from16 v33, v6

    const/4 v6, 0x2

    packed-switch v5, :pswitch_data_0

    const/16 v4, 0x3f

    if-ne v5, v4, :cond_4

    :try_start_5
    new-instance v4, Lluaj/d;

    const-string v5, "Damaged script: 5"

    invoke-direct {v4, v5}, Lluaj/d;-><init>(Ljava/lang/String;)V

    throw v4

    :catchall_1
    move-exception v0

    move-object v2, v0

    move v3, v11

    :goto_6
    move-object/from16 v13, v28

    move-object/from16 v28, v7

    goto/16 :goto_96

    :catch_3
    move-exception v0

    move-object v2, v0

    move-object/from16 v13, v28

    :goto_7
    move-object/from16 v28, v7

    goto/16 :goto_97

    :catch_4
    move-exception v0

    :goto_8
    move-object v2, v0

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    :goto_9
    move-object/from16 v28, v7

    goto/16 :goto_98

    :catch_5
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    move v4, v11

    move v3, v14

    move/from16 v6, v26

    :goto_a
    move/from16 v11, v27

    move-object/from16 v13, v28

    :goto_b
    move-object/from16 v28, v7

    goto/16 :goto_9a

    :cond_4
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Illegal opcode: "

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_5
    .catch Lluaj/d; {:try_start_5 .. :try_end_5} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_5 .. :try_end_5} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    :pswitch_0
    ushr-int/lit8 v5, v14, 0x17

    const/16 v6, 0xff

    if-le v5, v6, :cond_5

    and-int/lit16 v6, v5, 0xff

    :try_start_6
    aget-object v6, v9, v6
    :try_end_6
    .catch Lluaj/d; {:try_start_6 .. :try_end_6} :catch_6
    .catch Ljava/lang/StackOverflowError; {:try_start_6 .. :try_end_6} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_6 .. :try_end_6} :catch_3
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    goto :goto_c

    :catch_6
    move-exception v0

    move/from16 v22, v3

    move v6, v5

    move v4, v11

    move v3, v14

    move/from16 v11, v27

    move-object/from16 v13, v28

    move-object v5, v0

    goto :goto_b

    :cond_5
    :try_start_7
    aget-object v6, v2, v5
    :try_end_7
    .catch Lluaj/d; {:try_start_7 .. :try_end_7} :catch_8
    .catch Ljava/lang/StackOverflowError; {:try_start_7 .. :try_end_7} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_7 .. :try_end_7} :catch_3
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    :goto_c
    move/from16 v22, v5

    shr-int/lit8 v5, v14, 0xe

    move/from16 v34, v4

    and-int/lit16 v4, v5, 0x1ff

    move-object/from16 v35, v8

    const/16 v8, 0xff

    if-le v4, v8, :cond_6

    and-int/lit16 v5, v5, 0xff

    :try_start_8
    aget-object v5, v9, v5

    goto :goto_e

    :catch_7
    move-exception v0

    move-object v5, v0

    move/from16 v6, v22

    move-object/from16 v13, v28

    move/from16 v22, v3

    move-object/from16 v28, v7

    move v3, v14

    :goto_d
    move/from16 v38, v11

    move v11, v4

    move/from16 v4, v38

    goto/16 :goto_9a

    :cond_6
    aget-object v5, v2, v4

    :goto_e
    invoke-virtual {v6, v5}, Lluaj/LuaValue;->n2(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v5

    aput-object v5, v2, v3
    :try_end_8
    .catch Lluaj/d; {:try_start_8 .. :try_end_8} :catch_7
    .catch Ljava/lang/StackOverflowError; {:try_start_8 .. :try_end_8} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_8 .. :try_end_8} :catch_3
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    move/from16 v23, v3

    move/from16 v27, v4

    :goto_f
    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move/from16 v26, v22

    :goto_10
    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v6, v31

    :goto_11
    move/from16 v5, v34

    :goto_12
    const/4 v3, 0x1

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    goto/16 :goto_92

    :catch_8
    move-exception v0

    move/from16 v22, v5

    :goto_13
    move-object v5, v0

    move v4, v11

    move/from16 v6, v22

    :goto_14
    move/from16 v11, v27

    move-object/from16 v13, v28

    move/from16 v22, v3

    move-object/from16 v28, v7

    :goto_15
    move v3, v14

    goto/16 :goto_9a

    :pswitch_1
    move/from16 v34, v4

    move-object/from16 v35, v8

    ushr-int/lit8 v4, v14, 0x17

    const/16 v5, 0xff

    if-le v4, v5, :cond_7

    and-int/lit16 v5, v4, 0xff

    :try_start_9
    aget-object v5, v9, v5
    :try_end_9
    .catch Lluaj/d; {:try_start_9 .. :try_end_9} :catch_9
    .catch Ljava/lang/StackOverflowError; {:try_start_9 .. :try_end_9} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_9 .. :try_end_9} :catch_3
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    goto :goto_16

    :catch_9
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    move v6, v4

    move v4, v11

    move v3, v14

    goto/16 :goto_a

    :cond_7
    :try_start_a
    aget-object v5, v2, v4
    :try_end_a
    .catch Lluaj/d; {:try_start_a .. :try_end_a} :catch_b
    .catch Ljava/lang/StackOverflowError; {:try_start_a .. :try_end_a} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_a .. :try_end_a} :catch_3
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    :goto_16
    shr-int/lit8 v6, v14, 0xe

    and-int/lit16 v8, v6, 0x1ff

    move/from16 v22, v4

    const/16 v4, 0xff

    if-le v8, v4, :cond_8

    and-int/lit16 v4, v6, 0xff

    :try_start_b
    aget-object v4, v9, v4

    goto :goto_17

    :catch_a
    move-exception v0

    move-object v5, v0

    move v4, v11

    move/from16 v6, v22

    move-object/from16 v13, v28

    move/from16 v22, v3

    move-object/from16 v28, v7

    move v11, v8

    goto :goto_15

    :cond_8
    aget-object v4, v2, v8

    :goto_17
    invoke-virtual {v5, v4}, Lluaj/LuaValue;->m2(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v4

    aput-object v4, v2, v3
    :try_end_b
    .catch Lluaj/d; {:try_start_b .. :try_end_b} :catch_a
    .catch Ljava/lang/StackOverflowError; {:try_start_b .. :try_end_b} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_b .. :try_end_b} :catch_3
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    :goto_18
    move/from16 v23, v3

    move/from16 v27, v8

    goto :goto_f

    :catch_b
    move-exception v0

    move/from16 v22, v4

    goto :goto_13

    :pswitch_2
    move/from16 v34, v4

    move-object/from16 v35, v8

    ushr-int/lit8 v4, v14, 0x17

    const/16 v5, 0xff

    if-le v4, v5, :cond_9

    and-int/lit16 v5, v4, 0xff

    :try_start_c
    aget-object v5, v9, v5
    :try_end_c
    .catch Lluaj/d; {:try_start_c .. :try_end_c} :catch_9
    .catch Ljava/lang/StackOverflowError; {:try_start_c .. :try_end_c} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_c .. :try_end_c} :catch_3
    .catchall {:try_start_c .. :try_end_c} :catchall_1

    goto :goto_19

    :cond_9
    :try_start_d
    aget-object v5, v2, v4
    :try_end_d
    .catch Lluaj/d; {:try_start_d .. :try_end_d} :catch_b
    .catch Ljava/lang/StackOverflowError; {:try_start_d .. :try_end_d} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_d .. :try_end_d} :catch_3
    .catchall {:try_start_d .. :try_end_d} :catchall_1

    :goto_19
    shr-int/lit8 v6, v14, 0xe

    and-int/lit16 v8, v6, 0x1ff

    move/from16 v22, v4

    const/16 v4, 0xff

    if-le v8, v4, :cond_a

    and-int/lit16 v4, v6, 0xff

    :try_start_e
    aget-object v4, v9, v4

    goto :goto_1a

    :cond_a
    aget-object v4, v2, v8

    :goto_1a
    invoke-virtual {v5, v4}, Lluaj/LuaValue;->t0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v4

    aput-object v4, v2, v3
    :try_end_e
    .catch Lluaj/d; {:try_start_e .. :try_end_e} :catch_a
    .catch Ljava/lang/StackOverflowError; {:try_start_e .. :try_end_e} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_e .. :try_end_e} :catch_3
    .catchall {:try_start_e .. :try_end_e} :catchall_1

    goto :goto_18

    :pswitch_3
    move/from16 v34, v4

    move-object/from16 v35, v8

    ushr-int/lit8 v4, v14, 0x17

    const/16 v5, 0xff

    if-le v4, v5, :cond_b

    and-int/lit16 v5, v4, 0xff

    :try_start_f
    aget-object v5, v9, v5
    :try_end_f
    .catch Lluaj/d; {:try_start_f .. :try_end_f} :catch_9
    .catch Ljava/lang/StackOverflowError; {:try_start_f .. :try_end_f} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_f .. :try_end_f} :catch_3
    .catchall {:try_start_f .. :try_end_f} :catchall_1

    goto :goto_1b

    :cond_b
    :try_start_10
    aget-object v5, v2, v4
    :try_end_10
    .catch Lluaj/d; {:try_start_10 .. :try_end_10} :catch_b
    .catch Ljava/lang/StackOverflowError; {:try_start_10 .. :try_end_10} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_10 .. :try_end_10} :catch_3
    .catchall {:try_start_10 .. :try_end_10} :catchall_1

    :goto_1b
    shr-int/lit8 v6, v14, 0xe

    and-int/lit16 v8, v6, 0x1ff

    move/from16 v22, v4

    const/16 v4, 0xff

    if-le v8, v4, :cond_c

    and-int/lit16 v4, v6, 0xff

    :try_start_11
    aget-object v4, v9, v4

    goto :goto_1c

    :cond_c
    aget-object v4, v2, v8

    :goto_1c
    invoke-virtual {v5, v4}, Lluaj/LuaValue;->r0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v4

    aput-object v4, v2, v3
    :try_end_11
    .catch Lluaj/d; {:try_start_11 .. :try_end_11} :catch_a
    .catch Ljava/lang/StackOverflowError; {:try_start_11 .. :try_end_11} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_11 .. :try_end_11} :catch_3
    .catchall {:try_start_11 .. :try_end_11} :catchall_1

    goto :goto_18

    :pswitch_4
    move/from16 v34, v4

    move-object/from16 v35, v8

    ushr-int/lit8 v4, v14, 0x17

    const/16 v5, 0xff

    if-le v4, v5, :cond_d

    and-int/lit16 v5, v4, 0xff

    :try_start_12
    aget-object v5, v9, v5
    :try_end_12
    .catch Lluaj/d; {:try_start_12 .. :try_end_12} :catch_9
    .catch Ljava/lang/StackOverflowError; {:try_start_12 .. :try_end_12} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_12 .. :try_end_12} :catch_3
    .catchall {:try_start_12 .. :try_end_12} :catchall_1

    goto :goto_1d

    :cond_d
    :try_start_13
    aget-object v5, v2, v4
    :try_end_13
    .catch Lluaj/d; {:try_start_13 .. :try_end_13} :catch_b
    .catch Ljava/lang/StackOverflowError; {:try_start_13 .. :try_end_13} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_13 .. :try_end_13} :catch_3
    .catchall {:try_start_13 .. :try_end_13} :catchall_1

    :goto_1d
    shr-int/lit8 v6, v14, 0xe

    and-int/lit16 v8, v6, 0x1ff

    move/from16 v22, v4

    const/16 v4, 0xff

    if-le v8, v4, :cond_e

    and-int/lit16 v4, v6, 0xff

    :try_start_14
    aget-object v4, v9, v4

    goto :goto_1e

    :cond_e
    aget-object v4, v2, v8

    :goto_1e
    invoke-virtual {v5, v4}, Lluaj/LuaValue;->o0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v4

    aput-object v4, v2, v3
    :try_end_14
    .catch Lluaj/d; {:try_start_14 .. :try_end_14} :catch_a
    .catch Ljava/lang/StackOverflowError; {:try_start_14 .. :try_end_14} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_14 .. :try_end_14} :catch_3
    .catchall {:try_start_14 .. :try_end_14} :catchall_1

    goto/16 :goto_18

    :pswitch_5
    move/from16 v34, v4

    move-object/from16 v35, v8

    ushr-int/lit8 v4, v14, 0x17

    :try_start_15
    aget-object v4, v2, v4

    invoke-virtual {v4}, Lluaj/LuaValue;->q0()Lluaj/LuaValue;

    move-result-object v4

    aput-object v4, v2, v3
    :try_end_15
    .catch Lluaj/d; {:try_start_15 .. :try_end_15} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_15 .. :try_end_15} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_15 .. :try_end_15} :catch_3
    .catchall {:try_start_15 .. :try_end_15} :catchall_1

    move/from16 v33, v11

    move-object/from16 v36, v12

    :goto_1f
    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    :goto_20
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    goto/16 :goto_8e

    :pswitch_6
    move/from16 v34, v4

    move-object/from16 v35, v8

    ushr-int/lit8 v4, v14, 0x17

    const/16 v5, 0xff

    if-le v4, v5, :cond_f

    and-int/lit16 v5, v4, 0xff

    :try_start_16
    aget-object v5, v9, v5
    :try_end_16
    .catch Lluaj/d; {:try_start_16 .. :try_end_16} :catch_9
    .catch Ljava/lang/StackOverflowError; {:try_start_16 .. :try_end_16} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_16 .. :try_end_16} :catch_3
    .catchall {:try_start_16 .. :try_end_16} :catchall_1

    goto :goto_21

    :cond_f
    :try_start_17
    aget-object v5, v2, v4
    :try_end_17
    .catch Lluaj/d; {:try_start_17 .. :try_end_17} :catch_b
    .catch Ljava/lang/StackOverflowError; {:try_start_17 .. :try_end_17} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_17 .. :try_end_17} :catch_3
    .catchall {:try_start_17 .. :try_end_17} :catchall_1

    :goto_21
    shr-int/lit8 v6, v14, 0xe

    and-int/lit16 v8, v6, 0x1ff

    move/from16 v22, v4

    const/16 v4, 0xff

    if-le v8, v4, :cond_10

    and-int/lit16 v4, v6, 0xff

    :try_start_18
    aget-object v4, v9, v4

    goto :goto_22

    :cond_10
    aget-object v4, v2, v8

    :goto_22
    invoke-virtual {v5, v4}, Lluaj/LuaValue;->Z0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v4

    aput-object v4, v2, v3
    :try_end_18
    .catch Lluaj/d; {:try_start_18 .. :try_end_18} :catch_a
    .catch Ljava/lang/StackOverflowError; {:try_start_18 .. :try_end_18} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_18 .. :try_end_18} :catch_3
    .catchall {:try_start_18 .. :try_end_18} :catchall_1

    goto/16 :goto_18

    :pswitch_7
    :try_start_19
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Uexecutable opcode: EXTRAARG"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_19
    .catch Lluaj/d; {:try_start_19 .. :try_end_19} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_19 .. :try_end_19} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_19 .. :try_end_19} :catch_3
    .catchall {:try_start_19 .. :try_end_19} :catchall_1

    :pswitch_8
    move/from16 v34, v4

    move-object/from16 v35, v8

    ushr-int/lit8 v4, v14, 0x17

    if-nez v4, :cond_11

    :try_start_1a
    iget-object v6, v1, Lluaj/LuaClosure;->V:Lluaj/Varargs;

    invoke-virtual {v6}, Lluaj/Varargs;->U()I

    move-result v26

    add-int v4, v3, v26

    move/from16 v23, v3

    move v5, v4

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    goto/16 :goto_12

    :cond_11
    iget-object v5, v1, Lluaj/LuaClosure;->V:Lluaj/Varargs;

    const/4 v6, 0x1

    :goto_23
    if-ge v6, v4, :cond_12

    add-int v8, v3, v6

    const/16 v20, 0x1

    add-int/lit8 v8, v8, -0x1

    invoke-virtual {v5, v6}, Lluaj/Varargs;->v(I)Lluaj/LuaValue;

    move-result-object v22

    aput-object v22, v2, v8
    :try_end_1a
    .catch Lluaj/d; {:try_start_1a .. :try_end_1a} :catch_9
    .catch Ljava/lang/StackOverflowError; {:try_start_1a .. :try_end_1a} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_1a .. :try_end_1a} :catch_3
    .catchall {:try_start_1a .. :try_end_1a} :catchall_1

    add-int/lit8 v6, v6, 0x1

    goto :goto_23

    :cond_12
    move/from16 v23, v3

    move/from16 v26, v4

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    goto/16 :goto_10

    :pswitch_9
    move/from16 v34, v4

    move-object/from16 v35, v8

    ushr-int/lit8 v4, v14, 0xe

    :try_start_1b
    aget-object v4, v12, v4

    new-instance v5, Lluaj/LuaClosure;

    const/4 v6, 0x0

    invoke-direct {v5, v4, v13, v6}, Lluaj/LuaClosure;-><init>(Lluaj/h;Lluaj/LuaValue;Z)V

    iput-object v15, v5, Lluaj/LuaClosure;->U:Ljava/lang/String;

    iget-object v4, v4, Lluaj/h;->f1728f:[Lgg_f/d;

    array-length v6, v4

    iget-object v8, v5, Lluaj/LuaClosure;->S:[Lluaj/i;

    move-object/from16 v36, v12

    const/4 v12, 0x0

    :goto_24
    if-ge v12, v6, :cond_14

    move/from16 v22, v6

    aget-object v6, v4, v12

    move-object/from16 v23, v4

    iget-boolean v4, v6, Lgg_f/d;->f1566b:Z

    if-eqz v4, :cond_13

    iget-short v4, v6, Lgg_f/d;->f1567c:S

    invoke-direct {v1, v2, v4, v7}, Lluaj/LuaClosure;->Z2([Lluaj/LuaValue;S[Lluaj/i;)Lluaj/i;

    move-result-object v4

    aput-object v4, v8, v12

    goto :goto_25

    :cond_13
    iget-short v4, v6, Lgg_f/d;->f1567c:S

    aget-object v4, v10, v4

    aput-object v4, v8, v12

    :goto_25
    add-int/lit8 v12, v12, 0x1

    move/from16 v6, v22

    move-object/from16 v4, v23

    goto :goto_24

    :cond_14
    aput-object v5, v2, v3
    :try_end_1b
    .catch Lluaj/d; {:try_start_1b .. :try_end_1b} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_1b .. :try_end_1b} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_1b .. :try_end_1b} :catch_3
    .catchall {:try_start_1b .. :try_end_1b} :catchall_1

    move/from16 v33, v11

    goto/16 :goto_1f

    :pswitch_a
    move/from16 v34, v4

    move-object/from16 v35, v8

    move-object/from16 v36, v12

    shr-int/lit8 v4, v14, 0xe

    and-int/lit16 v4, v4, 0x1ff

    if-nez v4, :cond_15

    add-int/lit8 v11, v11, 0x1

    :try_start_1c
    aget v4, v35, v11
    :try_end_1c
    .catch Lluaj/d; {:try_start_1c .. :try_end_1c} :catch_c
    .catch Ljava/lang/StackOverflowError; {:try_start_1c .. :try_end_1c} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_1c .. :try_end_1c} :catch_3
    .catchall {:try_start_1c .. :try_end_1c} :catchall_1

    :cond_15
    move/from16 v27, v4

    goto :goto_26

    :catch_c
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    move v3, v14

    move/from16 v6, v26

    move-object/from16 v13, v28

    move-object/from16 v28, v7

    goto/16 :goto_d

    :goto_26
    add-int/lit8 v4, v27, -0x1

    mul-int/lit8 v4, v4, 0x32

    :try_start_1d
    aget-object v5, v2, v3
    :try_end_1d
    .catch Lluaj/d; {:try_start_1d .. :try_end_1d} :catch_f
    .catch Ljava/lang/StackOverflowError; {:try_start_1d .. :try_end_1d} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_1d .. :try_end_1d} :catch_3
    .catchall {:try_start_1d .. :try_end_1d} :catchall_3

    ushr-int/lit8 v6, v14, 0x17

    if-nez v6, :cond_19

    sub-int v6, v34, v3

    const/4 v8, 0x1

    sub-int/2addr v6, v8

    :try_start_1e
    invoke-virtual/range {v31 .. v31}, Lluaj/Varargs;->U()I

    move-result v8
    :try_end_1e
    .catch Lluaj/d; {:try_start_1e .. :try_end_1e} :catch_e
    .catch Ljava/lang/StackOverflowError; {:try_start_1e .. :try_end_1e} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_1e .. :try_end_1e} :catch_3
    .catchall {:try_start_1e .. :try_end_1e} :catchall_3

    sub-int v8, v6, v8

    const/4 v12, 0x1

    :goto_27
    if-gt v12, v8, :cond_16

    move/from16 v22, v11

    add-int v11, v4, v12

    add-int v23, v3, v12

    move-object/from16 v37, v15

    :try_start_1f
    aget-object v15, v2, v23

    invoke-virtual {v5, v11, v15}, Lluaj/LuaValue;->e2(ILluaj/LuaValue;)V

    add-int/lit8 v12, v12, 0x1

    move/from16 v11, v22

    move-object/from16 v15, v37

    goto :goto_27

    :catchall_2
    move-exception v0

    :goto_28
    move-object v2, v0

    move/from16 v3, v22

    goto/16 :goto_6

    :catch_d
    move-exception v0

    :goto_29
    move-object v5, v0

    move/from16 v4, v22

    goto/16 :goto_14

    :cond_16
    move/from16 v22, v11

    move-object/from16 v37, v15

    :goto_2a
    if-gt v12, v6, :cond_17

    add-int v11, v4, v12

    sub-int v15, v12, v8

    move/from16 v23, v8

    move-object/from16 v8, v31

    invoke-virtual {v8, v15}, Lluaj/Varargs;->v(I)Lluaj/LuaValue;

    move-result-object v15

    invoke-virtual {v5, v11, v15}, Lluaj/LuaValue;->e2(ILluaj/LuaValue;)V

    add-int/lit8 v12, v12, 0x1

    move-object/from16 v31, v8

    move/from16 v8, v23

    goto :goto_2a

    :cond_17
    move-object/from16 v8, v31

    :cond_18
    move/from16 v26, v6

    goto :goto_2c

    :catchall_3
    move-exception v0

    move/from16 v22, v11

    goto :goto_28

    :catch_e
    move-exception v0

    move/from16 v22, v11

    goto :goto_29

    :cond_19
    move/from16 v22, v11

    move-object/from16 v37, v15

    move-object/from16 v8, v31

    add-int v11, v4, v6

    invoke-virtual {v5, v11}, Lluaj/LuaValue;->R1(I)V

    const/4 v11, 0x1

    :goto_2b
    if-gt v11, v6, :cond_18

    add-int v12, v4, v11

    add-int v15, v3, v11

    aget-object v15, v2, v15

    invoke-virtual {v5, v12, v15}, Lluaj/LuaValue;->e2(ILluaj/LuaValue;)V
    :try_end_1f
    .catch Lluaj/d; {:try_start_1f .. :try_end_1f} :catch_d
    .catch Ljava/lang/StackOverflowError; {:try_start_1f .. :try_end_1f} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_1f .. :try_end_1f} :catch_3
    .catchall {:try_start_1f .. :try_end_1f} :catchall_2

    add-int/lit8 v11, v11, 0x1

    goto :goto_2b

    :goto_2c
    move/from16 v23, v3

    move-object v6, v8

    move-object/from16 v19, v13

    move/from16 v11, v22

    :goto_2d
    move-object/from16 v13, v28

    move-object/from16 v4, v30

    goto/16 :goto_11

    :catch_f
    move-exception v0

    move/from16 v22, v11

    move-object v5, v0

    move/from16 v4, v22

    move/from16 v6, v26

    goto/16 :goto_14

    :pswitch_b
    move/from16 v34, v4

    move-object/from16 v35, v8

    move-object/from16 v36, v12

    move-object/from16 v37, v15

    move-object/from16 v8, v31

    add-int/lit8 v4, v3, 0x1

    :try_start_20
    aget-object v5, v2, v4

    invoke-virtual {v5}, Lluaj/LuaValue;->l1()Z

    move-result v5

    if-nez v5, :cond_1a

    aget-object v4, v2, v4

    aput-object v4, v2, v3
    :try_end_20
    .catch Lluaj/d; {:try_start_20 .. :try_end_20} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_20 .. :try_end_20} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_20 .. :try_end_20} :catch_3
    .catchall {:try_start_20 .. :try_end_20} :catchall_1

    ushr-int/lit8 v4, v14, 0xe

    sub-int v4, v4, v32

    add-int/2addr v11, v4

    move/from16 v23, v3

    move-object v6, v8

    move-object/from16 v19, v13

    goto :goto_2d

    :cond_1a
    move/from16 v33, v11

    move-object/from16 v19, v13

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    goto/16 :goto_20

    :pswitch_c
    move/from16 v34, v4

    move-object/from16 v35, v8

    move-object/from16 v36, v12

    move-object/from16 v37, v15

    :try_start_21
    aget-object v4, v2, v3

    invoke-direct {v1, v4}, Lluaj/LuaClosure;->e3(Lluaj/LuaValue;)V
    :try_end_21
    .catch Lluaj/d; {:try_start_21 .. :try_end_21} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_21 .. :try_end_21} :catch_12
    .catch Ljava/lang/InterruptedException; {:try_start_21 .. :try_end_21} :catch_3
    .catchall {:try_start_21 .. :try_end_21} :catchall_1

    :try_start_22
    aget-object v4, v2, v3

    add-int/lit8 v5, v3, 0x1

    aget-object v5, v2, v5

    add-int/lit8 v6, v3, 0x2

    aget-object v6, v2, v6

    invoke-static {v5, v6}, Lluaj/LuaValue;->N2(Lluaj/LuaValue;Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v5

    invoke-virtual {v4, v5}, Lluaj/LuaValue;->invoke(Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v4

    invoke-direct {v1, v4}, Lluaj/LuaClosure;->W2(Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v4
    :try_end_22
    .catch Ljava/lang/NullPointerException; {:try_start_22 .. :try_end_22} :catch_10
    .catch Lluaj/d; {:try_start_22 .. :try_end_22} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_22 .. :try_end_22} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_22 .. :try_end_22} :catch_3
    .catchall {:try_start_22 .. :try_end_22} :catchall_1

    shr-int/lit8 v5, v14, 0xe

    and-int/lit16 v5, v5, 0x1ff

    :goto_2e
    add-int/lit8 v27, v5, -0x1

    if-ltz v27, :cond_1b

    add-int/lit8 v6, v3, 0x3

    add-int v6, v6, v27

    :try_start_23
    invoke-virtual {v4, v5}, Lluaj/Varargs;->v(I)Lluaj/LuaValue;

    move-result-object v5

    aput-object v5, v2, v6
    :try_end_23
    .catch Lluaj/d; {:try_start_23 .. :try_end_23} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_23 .. :try_end_23} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_23 .. :try_end_23} :catch_3
    .catchall {:try_start_23 .. :try_end_23} :catchall_1

    move/from16 v5, v27

    goto :goto_2e

    :cond_1b
    move/from16 v23, v3

    move-object/from16 v19, v13

    move-object/from16 v6, v25

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move/from16 v5, v34

    const/4 v3, 0x1

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object v9, v6

    goto/16 :goto_92

    :catch_10
    move-exception v0

    move-object v4, v0

    :try_start_24
    new-instance v5, Ljava/lang/NullPointerException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v12, v33

    invoke-virtual {v6, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    aget-object v8, v2, v3

    invoke-virtual {v8}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-object/from16 v15, v22

    invoke-virtual {v6, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v8, v3, 0x1

    aget-object v8, v2, v8

    add-int/lit8 v9, v3, 0x2

    aget-object v9, v2, v9

    invoke-static {v8, v9}, Lluaj/LuaValue;->N2(Lluaj/LuaValue;Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    :try_end_24
    .catch Lluaj/d; {:try_start_24 .. :try_end_24} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_24 .. :try_end_24} :catch_12
    .catch Ljava/lang/InterruptedException; {:try_start_24 .. :try_end_24} :catch_3
    .catchall {:try_start_24 .. :try_end_24} :catchall_1

    move-object/from16 v12, v30

    :try_start_25
    invoke-virtual {v6, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v4}, Ljava/lang/Throwable;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    throw v5
    :try_end_25
    .catch Lluaj/d; {:try_start_25 .. :try_end_25} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_25 .. :try_end_25} :catch_11
    .catch Ljava/lang/InterruptedException; {:try_start_25 .. :try_end_25} :catch_3
    .catchall {:try_start_25 .. :try_end_25} :catchall_1

    :catch_11
    move-exception v0

    :goto_2f
    move-object v2, v0

    move-object v4, v12

    :goto_30
    move-object/from16 v13, v28

    goto/16 :goto_9

    :catch_12
    move-exception v0

    move-object/from16 v12, v30

    goto :goto_2f

    :pswitch_d
    move/from16 v34, v4

    move-object/from16 v35, v8

    move-object/from16 v36, v12

    move-object/from16 v37, v15

    move-object/from16 v12, v30

    move-object/from16 v8, v31

    :try_start_26
    aget-object v4, v2, v3

    const-string v5, "\'for\' initial value must be a number"

    invoke-virtual {v4, v5}, Lluaj/LuaValue;->F0(Ljava/lang/String;)Lluaj/LuaNumber;

    move-result-object v4

    add-int/lit8 v5, v3, 0x1

    aget-object v6, v2, v5

    const-string v15, "\'for\' limit must be a number"

    invoke-virtual {v6, v15}, Lluaj/LuaValue;->F0(Ljava/lang/String;)Lluaj/LuaNumber;

    move-result-object v6
    :try_end_26
    .catch Lluaj/d; {:try_start_26 .. :try_end_26} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_26 .. :try_end_26} :catch_13
    .catch Ljava/lang/InterruptedException; {:try_start_26 .. :try_end_26} :catch_3
    .catchall {:try_start_26 .. :try_end_26} :catchall_1

    add-int/lit8 v15, v3, 0x2

    move-object/from16 v30, v12

    :try_start_27
    aget-object v12, v2, v15

    move-object/from16 v31, v10

    const-string v10, "\'for\' step must be a number"

    invoke-virtual {v12, v10}, Lluaj/LuaValue;->F0(Ljava/lang/String;)Lluaj/LuaNumber;

    move-result-object v10

    invoke-virtual {v4, v10}, Lluaj/LuaValue;->r2(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v4

    aput-object v4, v2, v3

    aput-object v6, v2, v5

    aput-object v10, v2, v15

    ushr-int/lit8 v4, v14, 0xe

    sub-int v4, v4, v32

    add-int/2addr v11, v4

    move/from16 v23, v3

    move-object v6, v8

    :goto_31
    move-object/from16 v19, v13

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move/from16 v5, v34

    const/4 v3, 0x1

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v9, v25

    :goto_32
    move-object/from16 v7, v31

    goto/16 :goto_92

    :catch_13
    move-exception v0

    move-object/from16 v30, v12

    goto/16 :goto_8

    :pswitch_e
    move/from16 v34, v4

    move-object/from16 v35, v8

    move-object/from16 v36, v12

    move-object/from16 v37, v15

    move-object/from16 v8, v31

    move-object/from16 v31, v10

    add-int/lit8 v4, v3, 0x1

    aget-object v4, v2, v4

    add-int/lit8 v5, v3, 0x2

    aget-object v5, v2, v5

    aget-object v6, v2, v3

    invoke-virtual {v6, v5}, Lluaj/LuaValue;->j0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v6

    move-object/from16 v10, v29

    invoke-virtual {v5, v10}, Lluaj/LuaValue;->X0(Lluaj/LuaValue;)Z

    move-result v5

    if-eqz v5, :cond_1c

    invoke-virtual {v6, v4}, Lluaj/LuaValue;->v1(Lluaj/LuaValue;)Z

    move-result v4

    if-eqz v4, :cond_1d

    goto :goto_33

    :cond_1c
    invoke-virtual {v6, v4}, Lluaj/LuaValue;->Y0(Lluaj/LuaValue;)Z

    move-result v4

    if-eqz v4, :cond_1d

    :goto_33
    aput-object v6, v2, v3

    add-int/lit8 v4, v3, 0x3

    aput-object v6, v2, v4
    :try_end_27
    .catch Lluaj/d; {:try_start_27 .. :try_end_27} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_27 .. :try_end_27} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_27 .. :try_end_27} :catch_3
    .catchall {:try_start_27 .. :try_end_27} :catchall_1

    ushr-int/lit8 v4, v14, 0xe

    sub-int v4, v4, v32

    add-int/2addr v11, v4

    :cond_1d
    move/from16 v23, v3

    move-object v6, v8

    move-object/from16 v29, v10

    goto :goto_31

    :pswitch_f
    move/from16 v34, v4

    move-object/from16 v8, v31

    ushr-int/lit8 v4, v14, 0x17

    if-eqz v4, :cond_28

    const/4 v5, 0x1

    if-eq v4, v5, :cond_24

    if-eq v4, v6, :cond_21

    add-int/lit8 v5, v4, -0x1

    :try_start_28
    invoke-static {v2, v3, v5}, Lluaj/LuaValue;->P2([Lluaj/LuaValue;II)Lluaj/Varargs;

    move-result-object v2
    :try_end_28
    .catch Lluaj/d; {:try_start_28 .. :try_end_28} :catch_9
    .catch Ljava/lang/StackOverflowError; {:try_start_28 .. :try_end_28} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_28 .. :try_end_28} :catch_3
    .catchall {:try_start_28 .. :try_end_28} :catchall_1

    if-eqz v7, :cond_1f

    move/from16 v11, v24

    :cond_1e
    :goto_34
    const/4 v3, -0x1

    add-int/2addr v11, v3

    if-ltz v11, :cond_1f

    aget-object v3, v7, v11

    if-eqz v3, :cond_1e

    invoke-virtual {v3}, Lluaj/i;->a()V

    goto :goto_34

    :cond_1f
    if-eqz v28, :cond_20

    if-nez p3, :cond_20

    :goto_35
    invoke-virtual/range {v28 .. v28}, Lluaj/lib/DebugLib;->l3()V

    :cond_20
    sget-object v3, Lluaj/LuaValue;->f1676f:Lluaj/LuaValue;

    iput-object v3, v1, Lluaj/LuaClosure;->V:Lluaj/Varargs;

    sget v3, Lluaj/LuaClosure;->Y:I

    const/4 v4, 0x1

    sub-int/2addr v3, v4

    sput v3, Lluaj/LuaClosure;->Y:I

    return-object v2

    :cond_21
    :try_start_29
    aget-object v2, v2, v3
    :try_end_29
    .catch Lluaj/d; {:try_start_29 .. :try_end_29} :catch_9
    .catch Ljava/lang/StackOverflowError; {:try_start_29 .. :try_end_29} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_29 .. :try_end_29} :catch_3
    .catchall {:try_start_29 .. :try_end_29} :catchall_1

    if-eqz v7, :cond_23

    move/from16 v11, v24

    :cond_22
    :goto_36
    const/4 v3, -0x1

    add-int/2addr v11, v3

    if-ltz v11, :cond_23

    aget-object v3, v7, v11

    if-eqz v3, :cond_22

    invoke-virtual {v3}, Lluaj/i;->a()V

    goto :goto_36

    :cond_23
    if-eqz v28, :cond_20

    if-nez p3, :cond_20

    goto :goto_35

    :cond_24
    if-eqz v7, :cond_26

    move/from16 v11, v24

    :cond_25
    :goto_37
    const/4 v2, -0x1

    add-int/2addr v11, v2

    if-ltz v11, :cond_26

    aget-object v2, v7, v11

    if-eqz v2, :cond_25

    invoke-virtual {v2}, Lluaj/i;->a()V

    goto :goto_37

    :cond_26
    if-eqz v28, :cond_27

    if-nez p3, :cond_27

    invoke-virtual/range {v28 .. v28}, Lluaj/lib/DebugLib;->l3()V

    :cond_27
    sget-object v2, Lluaj/LuaValue;->f1676f:Lluaj/LuaValue;

    iput-object v2, v1, Lluaj/LuaClosure;->V:Lluaj/Varargs;

    sget v2, Lluaj/LuaClosure;->Y:I

    const/4 v3, 0x1

    sub-int/2addr v2, v3

    sput v2, Lluaj/LuaClosure;->Y:I

    return-object v25

    :cond_28
    move/from16 v5, v34

    :try_start_2a
    invoke-virtual {v8}, Lluaj/Varargs;->U()I

    move-result v6

    sub-int/2addr v5, v6

    sub-int/2addr v5, v3

    invoke-static {v2, v3, v5, v8}, Lluaj/LuaValue;->Q2([Lluaj/LuaValue;IILluaj/Varargs;)Lluaj/Varargs;

    move-result-object v2
    :try_end_2a
    .catch Lluaj/d; {:try_start_2a .. :try_end_2a} :catch_9
    .catch Ljava/lang/StackOverflowError; {:try_start_2a .. :try_end_2a} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_2a .. :try_end_2a} :catch_3
    .catchall {:try_start_2a .. :try_end_2a} :catchall_1

    if-eqz v7, :cond_2a

    move/from16 v11, v24

    :cond_29
    :goto_38
    const/4 v3, -0x1

    add-int/2addr v11, v3

    if-ltz v11, :cond_2a

    aget-object v3, v7, v11

    if-eqz v3, :cond_29

    invoke-virtual {v3}, Lluaj/i;->a()V

    goto :goto_38

    :cond_2a
    if-eqz v28, :cond_20

    if-nez p3, :cond_20

    goto :goto_35

    :pswitch_10
    move v5, v4

    move-object/from16 v8, v31

    :try_start_2b
    aget-object v4, v2, v3

    invoke-direct {v1, v4}, Lluaj/LuaClosure;->e3(Lluaj/LuaValue;)V
    :try_end_2b
    .catch Lluaj/d; {:try_start_2b .. :try_end_2b} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_2b .. :try_end_2b} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_2b .. :try_end_2b} :catch_3
    .catchall {:try_start_2b .. :try_end_2b} :catchall_1

    const/high16 v4, -0x800000    # Float.NEGATIVE_INFINITY

    and-int/2addr v4, v14

    const/high16 v6, 0x800000

    if-eq v4, v6, :cond_2f

    const/high16 v6, 0x1000000

    if-eq v4, v6, :cond_2e

    const/high16 v6, 0x1800000

    if-eq v4, v6, :cond_2d

    const/high16 v6, 0x2000000

    if-eq v4, v6, :cond_2c

    ushr-int/lit8 v4, v14, 0x17

    if-lez v4, :cond_2b

    add-int/lit8 v5, v3, 0x1

    add-int/lit8 v6, v4, -0x1

    :try_start_2c
    invoke-static {v2, v5, v6}, Lluaj/LuaValue;->P2([Lluaj/LuaValue;II)Lluaj/Varargs;

    move-result-object v5

    :goto_39
    move-object v6, v5

    goto :goto_3a

    :cond_2b
    add-int/lit8 v6, v3, 0x1

    invoke-virtual {v8}, Lluaj/Varargs;->U()I

    move-result v9

    sub-int/2addr v5, v9

    sub-int/2addr v5, v6

    invoke-static {v2, v6, v5, v8}, Lluaj/LuaValue;->Q2([Lluaj/LuaValue;IILluaj/Varargs;)Lluaj/Varargs;

    move-result-object v5
    :try_end_2c
    .catch Lluaj/d; {:try_start_2c .. :try_end_2c} :catch_9
    .catch Ljava/lang/StackOverflowError; {:try_start_2c .. :try_end_2c} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_2c .. :try_end_2c} :catch_3
    .catchall {:try_start_2c .. :try_end_2c} :catchall_1

    goto :goto_39

    :goto_3a
    move/from16 v26, v4

    goto :goto_3b

    :cond_2c
    add-int/lit8 v4, v3, 0x1

    :try_start_2d
    aget-object v4, v2, v4

    add-int/lit8 v5, v3, 0x2

    aget-object v5, v2, v5

    add-int/lit8 v6, v3, 0x3

    aget-object v6, v2, v6

    invoke-static {v4, v5, v6}, Lluaj/LuaValue;->M2(Lluaj/LuaValue;Lluaj/LuaValue;Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v6

    goto :goto_3b

    :cond_2d
    add-int/lit8 v4, v3, 0x1

    aget-object v4, v2, v4

    add-int/lit8 v5, v3, 0x2

    aget-object v5, v2, v5

    invoke-static {v4, v5}, Lluaj/LuaValue;->N2(Lluaj/LuaValue;Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v6

    goto :goto_3b

    :cond_2e
    add-int/lit8 v4, v3, 0x1

    aget-object v6, v2, v4

    goto :goto_3b

    :cond_2f
    move-object/from16 v6, v25

    :goto_3b
    new-instance v4, Lgg_f/c;

    aget-object v5, v2, v3

    invoke-direct {v4, v13, v5, v6}, Lgg_f/c;-><init>(Lluaj/Globals;Lluaj/LuaValue;Lluaj/Varargs;)V

    if-nez p3, :cond_30

    invoke-virtual {v4}, Lluaj/Varargs;->N()Lluaj/Varargs;

    move-result-object v4
    :try_end_2d
    .catch Lluaj/d; {:try_start_2d .. :try_end_2d} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_2d .. :try_end_2d} :catch_4
    .catch Ljava/lang/InterruptedException; {:try_start_2d .. :try_end_2d} :catch_3
    .catchall {:try_start_2d .. :try_end_2d} :catchall_1

    :cond_30
    if-eqz v7, :cond_32

    move/from16 v11, v24

    :cond_31
    :goto_3c
    const/4 v2, -0x1

    add-int/2addr v11, v2

    if-ltz v11, :cond_32

    aget-object v2, v7, v11

    if-eqz v2, :cond_31

    invoke-virtual {v2}, Lluaj/i;->a()V

    goto :goto_3c

    :cond_32
    if-eqz v28, :cond_33

    if-nez p3, :cond_33

    invoke-virtual/range {v28 .. v28}, Lluaj/lib/DebugLib;->l3()V

    :cond_33
    sget-object v2, Lluaj/LuaValue;->f1676f:Lluaj/LuaValue;

    iput-object v2, v1, Lluaj/LuaClosure;->V:Lluaj/Varargs;

    sget v2, Lluaj/LuaClosure;->Y:I

    const/4 v3, 0x1

    sub-int/2addr v2, v3

    sput v2, Lluaj/LuaClosure;->Y:I

    return-object v4

    :pswitch_11
    move v5, v4

    move-object/from16 v35, v8

    move-object/from16 v36, v12

    move-object/from16 v37, v15

    move-object/from16 v15, v22

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v12, v33

    move-object/from16 v31, v10

    move-object/from16 v10, v29

    :try_start_2e
    aget-object v6, v2, v3

    invoke-direct {v1, v6}, Lluaj/LuaClosure;->e3(Lluaj/LuaValue;)V
    :try_end_2e
    .catch Lluaj/d; {:try_start_2e .. :try_end_2e} :catch_25
    .catch Ljava/lang/StackOverflowError; {:try_start_2e .. :try_end_2e} :catch_24
    .catch Ljava/lang/InterruptedException; {:try_start_2e .. :try_end_2e} :catch_23
    .catchall {:try_start_2e .. :try_end_2e} :catchall_f

    if-eqz v28, :cond_34

    :try_start_2f
    aget-object v6, v2, v3

    invoke-virtual {v6}, Lluaj/LuaValue;->f1()Z

    move-result v6
    :try_end_2f
    .catch Ljava/lang/NullPointerException; {:try_start_2f .. :try_end_2f} :catch_15
    .catch Lluaj/d; {:try_start_2f .. :try_end_2f} :catch_5
    .catch Ljava/lang/StackOverflowError; {:try_start_2f .. :try_end_2f} :catch_14
    .catch Ljava/lang/InterruptedException; {:try_start_2f .. :try_end_2f} :catch_3
    .catchall {:try_start_2f .. :try_end_2f} :catchall_1

    if-nez v6, :cond_34

    const/4 v6, 0x1

    goto :goto_3e

    :catch_14
    move-exception v0

    move-object v2, v0

    goto/16 :goto_30

    :catch_15
    move-exception v0

    move-object v6, v8

    move/from16 v33, v11

    move-object/from16 v9, v25

    move-object/from16 v13, v28

    move-object/from16 v28, v7

    :goto_3d
    move-object v7, v0

    goto/16 :goto_5c

    :cond_34
    const/4 v6, 0x0

    :goto_3e
    if-eqz v6, :cond_36

    :try_start_30
    aget-object v22, v2, v3

    invoke-virtual/range {v22 .. v22}, Lluaj/LuaValue;->g1()Z

    move-result v22

    if-eqz v22, :cond_35

    aget-object v22, v2, v3

    move/from16 v23, v6

    invoke-virtual/range {v22 .. v22}, Lluaj/LuaValue;->y0()Lluaj/LuaFunction;

    move-result-object v6
    :try_end_30
    .catch Ljava/lang/NullPointerException; {:try_start_30 .. :try_end_30} :catch_1d
    .catch Lluaj/d; {:try_start_30 .. :try_end_30} :catch_1c
    .catch Ljava/lang/StackOverflowError; {:try_start_30 .. :try_end_30} :catch_1b
    .catch Ljava/lang/InterruptedException; {:try_start_30 .. :try_end_30} :catch_1a
    .catchall {:try_start_30 .. :try_end_30} :catchall_5

    move-object/from16 v29, v10

    move-object/from16 v19, v13

    move-object/from16 v13, v28

    const/4 v10, 0x0

    :try_start_31
    invoke-virtual {v13, v6, v10}, Lluaj/lib/DebugLib;->j3(Lluaj/LuaFunction;Z)V
    :try_end_31
    .catch Ljava/lang/NullPointerException; {:try_start_31 .. :try_end_31} :catch_19
    .catch Lluaj/d; {:try_start_31 .. :try_end_31} :catch_18
    .catch Ljava/lang/StackOverflowError; {:try_start_31 .. :try_end_31} :catch_17
    .catch Ljava/lang/InterruptedException; {:try_start_31 .. :try_end_31} :catch_16
    .catchall {:try_start_31 .. :try_end_31} :catchall_4

    goto :goto_46

    :catchall_4
    move-exception v0

    :goto_3f
    move-object v2, v0

    move-object/from16 v28, v7

    :goto_40
    move v3, v11

    goto/16 :goto_96

    :catch_16
    move-exception v0

    :goto_41
    move-object v2, v0

    goto/16 :goto_7

    :catch_17
    move-exception v0

    :goto_42
    move-object v2, v0

    goto/16 :goto_9

    :catch_18
    move-exception v0

    :goto_43
    move-object v5, v0

    move/from16 v22, v3

    move-object/from16 v28, v7

    :goto_44
    move v4, v11

    move v3, v14

    goto/16 :goto_3

    :catch_19
    move-exception v0

    :goto_45
    move-object/from16 v28, v7

    move-object v6, v8

    move/from16 v33, v11

    move-object/from16 v9, v25

    goto :goto_3d

    :catchall_5
    move-exception v0

    move-object/from16 v13, v28

    goto :goto_3f

    :catch_1a
    move-exception v0

    move-object/from16 v13, v28

    goto :goto_41

    :catch_1b
    move-exception v0

    move-object/from16 v13, v28

    goto :goto_42

    :catch_1c
    move-exception v0

    move-object/from16 v13, v28

    goto :goto_43

    :catch_1d
    move-exception v0

    move-object/from16 v13, v28

    goto :goto_45

    :cond_35
    move-object/from16 v29, v10

    move-object/from16 v19, v13

    move-object/from16 v13, v28

    const/4 v10, 0x0

    const/4 v6, 0x0

    goto :goto_47

    :cond_36
    move/from16 v23, v6

    move-object/from16 v29, v10

    move-object/from16 v19, v13

    move-object/from16 v13, v28

    const/4 v10, 0x0

    :goto_46
    move/from16 v6, v23

    :goto_47
    and-int/lit16 v10, v14, -0x4000

    sparse-switch v10, :sswitch_data_0

    ushr-int/lit8 v26, v14, 0x17

    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v10, v10, 0x1ff

    move-object/from16 v28, v7

    :try_start_32
    aget-object v7, v2, v3
    :try_end_32
    .catchall {:try_start_32 .. :try_end_32} :catchall_8

    if-lez v26, :cond_37

    move-object/from16 v30, v9

    add-int/lit8 v9, v3, 0x1

    move/from16 v33, v11

    add-int/lit8 v11, v26, -0x1

    :try_start_33
    invoke-static {v2, v9, v11}, Lluaj/LuaValue;->P2([Lluaj/LuaValue;II)Lluaj/Varargs;

    move-result-object v9

    goto :goto_4a

    :catchall_6
    move-exception v0

    :goto_48
    move-object v7, v0

    move/from16 v27, v10

    :goto_49
    move-object/from16 v9, v25

    goto/16 :goto_5a

    :cond_37
    move-object/from16 v30, v9

    move/from16 v33, v11

    add-int/lit8 v9, v3, 0x1

    invoke-virtual {v8}, Lluaj/Varargs;->U()I

    move-result v11

    sub-int v11, v5, v11

    sub-int/2addr v11, v9

    invoke-static {v2, v9, v11, v8}, Lluaj/LuaValue;->Q2([Lluaj/LuaValue;IILluaj/Varargs;)Lluaj/Varargs;

    move-result-object v9

    :goto_4a
    invoke-virtual {v7, v9}, Lluaj/LuaValue;->invoke(Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v7

    invoke-direct {v1, v7}, Lluaj/LuaClosure;->W2(Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v7
    :try_end_33
    .catchall {:try_start_33 .. :try_end_33} :catchall_6

    if-lez v10, :cond_38

    add-int/lit8 v8, v10, -0x1

    :try_start_34
    invoke-virtual {v7, v2, v3, v8}, Lluaj/Varargs;->L([Lluaj/LuaValue;II)V

    move/from16 v27, v10

    move-object/from16 v7, v25

    move-object v9, v7

    goto/16 :goto_4f

    :catchall_7
    move-exception v0

    move-object v8, v7

    move/from16 v27, v10

    :goto_4b
    move-object/from16 v9, v25

    :goto_4c
    move-object v7, v0

    goto/16 :goto_5a

    :cond_38
    invoke-virtual {v7}, Lluaj/Varargs;->U()I

    move-result v5

    add-int/2addr v5, v3

    invoke-virtual {v7}, Lluaj/Varargs;->M()Lluaj/Varargs;

    move-result-object v7
    :try_end_34
    .catchall {:try_start_34 .. :try_end_34} :catchall_7

    move/from16 v27, v10

    :goto_4d
    move-object/from16 v9, v25

    goto/16 :goto_4f

    :catchall_8
    move-exception v0

    move/from16 v33, v11

    goto :goto_48

    :sswitch_0
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move/from16 v33, v11

    :try_start_35
    aget-object v7, v2, v3

    add-int/lit8 v9, v3, 0x1

    aget-object v9, v2, v9

    add-int/lit8 v10, v3, 0x2

    aget-object v10, v2, v10

    add-int/lit8 v11, v3, 0x3

    aget-object v11, v2, v11

    invoke-virtual {v7, v9, v10, v11}, Lluaj/LuaValue;->call(Lluaj/LuaValue;Lluaj/LuaValue;Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    invoke-direct {v1, v7}, Lluaj/LuaClosure;->V2(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    aput-object v7, v2, v3

    goto/16 :goto_4e

    :catchall_9
    move-exception v0

    move-object v7, v0

    goto :goto_49

    :sswitch_1
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move/from16 v33, v11

    aget-object v7, v2, v3

    add-int/lit8 v9, v3, 0x1

    aget-object v9, v2, v9

    add-int/lit8 v10, v3, 0x2

    aget-object v10, v2, v10

    add-int/lit8 v11, v3, 0x3

    aget-object v11, v2, v11

    invoke-virtual {v7, v9, v10, v11}, Lluaj/LuaValue;->call(Lluaj/LuaValue;Lluaj/LuaValue;Lluaj/LuaValue;)Lluaj/LuaValue;

    goto/16 :goto_4e

    :sswitch_2
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move/from16 v33, v11

    aget-object v7, v2, v3

    add-int/lit8 v9, v3, 0x1

    aget-object v9, v2, v9

    add-int/lit8 v10, v3, 0x2

    aget-object v10, v2, v10

    invoke-virtual {v7, v9, v10}, Lluaj/LuaValue;->call(Lluaj/LuaValue;Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    invoke-direct {v1, v7}, Lluaj/LuaClosure;->V2(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    aput-object v7, v2, v3

    goto/16 :goto_4e

    :sswitch_3
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move/from16 v33, v11

    aget-object v7, v2, v3

    add-int/lit8 v9, v3, 0x1

    aget-object v9, v2, v9

    add-int/lit8 v10, v3, 0x2

    aget-object v10, v2, v10

    invoke-virtual {v7, v9, v10}, Lluaj/LuaValue;->call(Lluaj/LuaValue;Lluaj/LuaValue;)Lluaj/LuaValue;

    goto/16 :goto_4e

    :sswitch_4
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move/from16 v33, v11

    aget-object v7, v2, v3

    add-int/lit8 v9, v3, 0x1

    aget-object v9, v2, v9

    invoke-virtual {v7, v9}, Lluaj/LuaValue;->call(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    invoke-direct {v1, v7}, Lluaj/LuaClosure;->V2(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    aput-object v7, v2, v3

    goto :goto_4e

    :sswitch_5
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move/from16 v33, v11

    aget-object v7, v2, v3

    add-int/lit8 v9, v3, 0x1

    aget-object v9, v2, v9

    invoke-virtual {v7, v9}, Lluaj/LuaValue;->call(Lluaj/LuaValue;)Lluaj/LuaValue;

    goto :goto_4e

    :sswitch_6
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move/from16 v33, v11

    aget-object v7, v2, v3

    add-int/lit8 v9, v3, 0x1

    aget-object v9, v2, v9

    invoke-virtual {v7, v9}, Lluaj/LuaValue;->invoke(Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v7

    invoke-direct {v1, v7}, Lluaj/LuaClosure;->W2(Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v7
    :try_end_35
    .catchall {:try_start_35 .. :try_end_35} :catchall_9

    :try_start_36
    invoke-virtual {v7}, Lluaj/Varargs;->U()I

    move-result v5
    :try_end_36
    .catchall {:try_start_36 .. :try_end_36} :catchall_a

    add-int/2addr v5, v3

    goto/16 :goto_4d

    :catchall_a
    move-exception v0

    move-object v8, v7

    goto/16 :goto_4b

    :sswitch_7
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move/from16 v33, v11

    :try_start_37
    aget-object v7, v2, v3

    invoke-virtual {v7}, Lluaj/LuaValue;->call()Lluaj/LuaValue;

    move-result-object v7

    invoke-direct {v1, v7}, Lluaj/LuaClosure;->V2(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    aput-object v7, v2, v3

    goto :goto_4e

    :sswitch_8
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move/from16 v33, v11

    aget-object v7, v2, v3

    invoke-virtual {v7}, Lluaj/LuaValue;->call()Lluaj/LuaValue;
    :try_end_37
    .catchall {:try_start_37 .. :try_end_37} :catchall_9

    :goto_4e
    move-object v7, v8

    goto/16 :goto_4d

    :sswitch_9
    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move/from16 v33, v11

    :try_start_38
    aget-object v7, v2, v3
    :try_end_38
    .catchall {:try_start_38 .. :try_end_38} :catchall_e

    move-object/from16 v9, v25

    :try_start_39
    invoke-virtual {v7, v9}, Lluaj/LuaValue;->invoke(Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v7

    invoke-direct {v1, v7}, Lluaj/LuaClosure;->W2(Lluaj/Varargs;)Lluaj/Varargs;

    move-result-object v7
    :try_end_39
    .catchall {:try_start_39 .. :try_end_39} :catchall_d

    :try_start_3a
    invoke-virtual {v7}, Lluaj/Varargs;->U()I

    move-result v5
    :try_end_3a
    .catchall {:try_start_3a .. :try_end_3a} :catchall_c

    add-int/2addr v5, v3

    :goto_4f
    if-eqz v6, :cond_39

    :try_start_3b
    invoke-virtual {v13}, Lluaj/lib/DebugLib;->l3()V
    :try_end_3b
    .catch Ljava/lang/NullPointerException; {:try_start_3b .. :try_end_3b} :catch_21
    .catch Lluaj/d; {:try_start_3b .. :try_end_3b} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_3b .. :try_end_3b} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_3b .. :try_end_3b} :catch_1e
    .catchall {:try_start_3b .. :try_end_3b} :catchall_b

    goto :goto_57

    :catchall_b
    move-exception v0

    :goto_50
    move-object v2, v0

    move/from16 v3, v33

    goto/16 :goto_96

    :catch_1e
    move-exception v0

    :goto_51
    move-object v2, v0

    goto/16 :goto_97

    :catch_1f
    move-exception v0

    :goto_52
    move-object v2, v0

    goto/16 :goto_98

    :catch_20
    move-exception v0

    :goto_53
    move-object v5, v0

    move/from16 v22, v3

    move v3, v14

    :goto_54
    move/from16 v6, v26

    :goto_55
    move/from16 v11, v27

    :goto_56
    move/from16 v4, v33

    goto/16 :goto_9a

    :catch_21
    move-exception v0

    move-object v6, v7

    goto/16 :goto_3d

    :cond_39
    :goto_57
    move/from16 v23, v3

    move-object v6, v7

    :goto_58
    move-object/from16 v7, v31

    move/from16 v11, v33

    :goto_59
    const/4 v3, 0x1

    goto/16 :goto_92

    :catchall_c
    move-exception v0

    move-object v8, v7

    goto/16 :goto_4c

    :catchall_d
    move-exception v0

    goto/16 :goto_4c

    :catchall_e
    move-exception v0

    goto/16 :goto_4b

    :goto_5a
    if-eqz v6, :cond_3a

    :try_start_3c
    invoke-virtual {v13}, Lluaj/lib/DebugLib;->l3()V

    goto :goto_5b

    :catch_22
    move-exception v0

    move-object v7, v0

    move-object v6, v8

    goto :goto_5c

    :cond_3a
    :goto_5b
    throw v7
    :try_end_3c
    .catch Ljava/lang/NullPointerException; {:try_start_3c .. :try_end_3c} :catch_22
    .catch Lluaj/d; {:try_start_3c .. :try_end_3c} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_3c .. :try_end_3c} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_3c .. :try_end_3c} :catch_1e
    .catchall {:try_start_3c .. :try_end_3c} :catchall_b

    :goto_5c
    :try_start_3d
    const-string v8, ""
    :try_end_3d
    .catch Lluaj/d; {:try_start_3d .. :try_end_3d} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_3d .. :try_end_3d} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_3d .. :try_end_3d} :catch_1e
    .catchall {:try_start_3d .. :try_end_3d} :catchall_b

    and-int/lit16 v10, v14, -0x4000

    const-string v11, ", "

    sparse-switch v10, :sswitch_data_1

    if-lez v26, :cond_3b

    add-int/lit8 v5, v3, 0x1

    add-int/lit8 v6, v26, -0x1

    :try_start_3e
    invoke-static {v2, v5, v6}, Lluaj/LuaValue;->P2([Lluaj/LuaValue;II)Lluaj/Varargs;

    move-result-object v5

    goto :goto_5d

    :cond_3b
    add-int/lit8 v8, v3, 0x1

    invoke-virtual {v6}, Lluaj/Varargs;->U()I

    move-result v9

    sub-int/2addr v5, v9

    sub-int/2addr v5, v8

    invoke-static {v2, v8, v5, v6}, Lluaj/LuaValue;->Q2([Lluaj/LuaValue;IILluaj/Varargs;)Lluaj/Varargs;

    move-result-object v5

    :goto_5d
    invoke-virtual {v5}, Lluaj/Varargs;->toString()Ljava/lang/String;

    move-result-object v8

    goto :goto_5f

    :sswitch_a
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    add-int/lit8 v6, v3, 0x1

    aget-object v6, v2, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v6, v3, 0x2

    aget-object v6, v2, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v6, v3, 0x3

    aget-object v6, v2, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    :goto_5e
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    goto :goto_5f

    :sswitch_b
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    add-int/lit8 v6, v3, 0x1

    aget-object v6, v2, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v6, v3, 0x2

    aget-object v6, v2, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_5e

    :sswitch_c
    add-int/lit8 v5, v3, 0x1

    aget-object v5, v2, v5

    invoke-virtual {v5}, Lluaj/LuaValue;->toString()Ljava/lang/String;

    move-result-object v8

    goto :goto_5f

    :sswitch_d
    invoke-virtual {v9}, Lluaj/LuaValue;->toString()Ljava/lang/String;

    move-result-object v8

    :goto_5f
    :sswitch_e
    new-instance v5, Ljava/lang/NullPointerException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    aget-object v9, v2, v3

    invoke-virtual {v9}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v7}, Ljava/lang/Throwable;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    throw v5

    :catchall_f
    move-exception v0

    move/from16 v33, v11

    move-object/from16 v13, v28

    move-object/from16 v28, v7

    goto/16 :goto_50

    :catch_23
    move-exception v0

    move-object/from16 v13, v28

    move-object/from16 v28, v7

    goto/16 :goto_51

    :catch_24
    move-exception v0

    :goto_60
    move-object/from16 v13, v28

    move-object/from16 v28, v7

    goto/16 :goto_52

    :catch_25
    move-exception v0

    move/from16 v33, v11

    move-object/from16 v13, v28

    move-object/from16 v28, v7

    goto/16 :goto_53

    :pswitch_12
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    aget-object v6, v2, v6

    invoke-virtual {v6}, Lluaj/LuaValue;->w2()Z

    move-result v7

    and-int v10, v14, v23

    if-eqz v10, :cond_3c

    const/4 v10, 0x1

    goto :goto_61

    :cond_3c
    const/4 v10, 0x0

    :goto_61
    if-eq v7, v10, :cond_3e

    :goto_62
    add-int/lit8 v11, v33, 0x1

    :cond_3d
    move/from16 v23, v3

    :goto_63
    move-object v6, v8

    move-object/from16 v7, v31

    goto/16 :goto_59

    :cond_3e
    aput-object v6, v2, v3

    :cond_3f
    :goto_64
    move/from16 v34, v5

    move-object/from16 v7, v31

    goto/16 :goto_8e

    :pswitch_13
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    aget-object v6, v2, v3

    invoke-virtual {v6}, Lluaj/LuaValue;->w2()Z

    move-result v6
    :try_end_3e
    .catch Lluaj/d; {:try_start_3e .. :try_end_3e} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_3e .. :try_end_3e} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_3e .. :try_end_3e} :catch_1e
    .catchall {:try_start_3e .. :try_end_3e} :catchall_b

    and-int v7, v14, v23

    if-eqz v7, :cond_40

    const/4 v7, 0x1

    goto :goto_65

    :cond_40
    const/4 v7, 0x0

    :goto_65
    if-eq v6, v7, :cond_3f

    goto :goto_62

    :pswitch_14
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    const/16 v7, 0xff

    if-le v6, v7, :cond_41

    and-int/lit16 v7, v6, 0xff

    :try_start_3f
    aget-object v7, v30, v7

    goto :goto_67

    :catch_26
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    :goto_66
    move v3, v14

    goto/16 :goto_55

    :cond_41
    aget-object v7, v2, v6
    :try_end_3f
    .catch Lluaj/d; {:try_start_3f .. :try_end_3f} :catch_26
    .catch Ljava/lang/StackOverflowError; {:try_start_3f .. :try_end_3f} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_3f .. :try_end_3f} :catch_1e
    .catchall {:try_start_3f .. :try_end_3f} :catchall_b

    :goto_67
    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v11, v10, 0x1ff

    const/16 v12, 0xff

    if-le v11, v12, :cond_42

    and-int/lit16 v10, v10, 0xff

    :try_start_40
    aget-object v10, v30, v10

    goto :goto_69

    :catch_27
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    :goto_68
    move v3, v14

    goto/16 :goto_56

    :cond_42
    aget-object v10, v2, v11

    :goto_69
    invoke-virtual {v7, v10}, Lluaj/LuaValue;->v1(Lluaj/LuaValue;)Z

    move-result v7
    :try_end_40
    .catch Lluaj/d; {:try_start_40 .. :try_end_40} :catch_27
    .catch Ljava/lang/StackOverflowError; {:try_start_40 .. :try_end_40} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_40 .. :try_end_40} :catch_1e
    .catchall {:try_start_40 .. :try_end_40} :catchall_b

    if-eqz v3, :cond_43

    const/4 v10, 0x1

    goto :goto_6a

    :cond_43
    const/4 v10, 0x0

    :goto_6a
    if-eq v7, v10, :cond_44

    :goto_6b
    add-int/lit8 v7, v33, 0x1

    move/from16 v23, v3

    move/from16 v26, v6

    move-object v6, v8

    move/from16 v27, v11

    const/4 v3, 0x1

    move v11, v7

    goto/16 :goto_32

    :cond_44
    :goto_6c
    move/from16 v23, v3

    move/from16 v26, v6

    move-object v6, v8

    move/from16 v27, v11

    goto/16 :goto_58

    :pswitch_15
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    const/16 v7, 0xff

    if-le v6, v7, :cond_45

    and-int/lit16 v7, v6, 0xff

    :try_start_41
    aget-object v7, v30, v7

    goto :goto_6d

    :cond_45
    aget-object v7, v2, v6
    :try_end_41
    .catch Lluaj/d; {:try_start_41 .. :try_end_41} :catch_26
    .catch Ljava/lang/StackOverflowError; {:try_start_41 .. :try_end_41} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_41 .. :try_end_41} :catch_1e
    .catchall {:try_start_41 .. :try_end_41} :catchall_b

    :goto_6d
    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v11, v10, 0x1ff

    const/16 v12, 0xff

    if-le v11, v12, :cond_46

    and-int/lit16 v10, v10, 0xff

    :try_start_42
    aget-object v10, v30, v10

    goto :goto_6e

    :cond_46
    aget-object v10, v2, v11

    :goto_6e
    invoke-virtual {v7, v10}, Lluaj/LuaValue;->u1(Lluaj/LuaValue;)Z

    move-result v7
    :try_end_42
    .catch Lluaj/d; {:try_start_42 .. :try_end_42} :catch_27
    .catch Ljava/lang/StackOverflowError; {:try_start_42 .. :try_end_42} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_42 .. :try_end_42} :catch_1e
    .catchall {:try_start_42 .. :try_end_42} :catchall_b

    if-eqz v3, :cond_47

    const/4 v10, 0x1

    goto :goto_6f

    :cond_47
    const/4 v10, 0x0

    :goto_6f
    if-eq v7, v10, :cond_44

    goto :goto_6b

    :pswitch_16
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    const/16 v7, 0xff

    if-le v6, v7, :cond_48

    and-int/lit16 v7, v6, 0xff

    :try_start_43
    aget-object v7, v30, v7

    goto :goto_70

    :cond_48
    aget-object v7, v2, v6
    :try_end_43
    .catch Lluaj/d; {:try_start_43 .. :try_end_43} :catch_26
    .catch Ljava/lang/StackOverflowError; {:try_start_43 .. :try_end_43} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_43 .. :try_end_43} :catch_1e
    .catchall {:try_start_43 .. :try_end_43} :catchall_b

    :goto_70
    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v11, v10, 0x1ff

    const/16 v12, 0xff

    if-le v11, v12, :cond_49

    and-int/lit16 v10, v10, 0xff

    :try_start_44
    aget-object v10, v30, v10

    goto :goto_71

    :cond_49
    aget-object v10, v2, v11

    :goto_71
    invoke-virtual {v7, v10}, Lluaj/LuaValue;->P0(Lluaj/LuaValue;)Z

    move-result v7
    :try_end_44
    .catch Lluaj/d; {:try_start_44 .. :try_end_44} :catch_27
    .catch Ljava/lang/StackOverflowError; {:try_start_44 .. :try_end_44} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_44 .. :try_end_44} :catch_1e
    .catchall {:try_start_44 .. :try_end_44} :catchall_b

    if-eqz v3, :cond_4a

    const/4 v10, 0x1

    goto :goto_72

    :cond_4a
    const/4 v10, 0x0

    :goto_72
    if-eq v7, v10, :cond_44

    goto/16 :goto_6b

    :pswitch_17
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0xe

    sub-int v6, v6, v32

    add-int v11, v33, v6

    if-lez v3, :cond_3d

    add-int/lit8 v3, v3, -0x1

    if-eqz v28, :cond_3d

    move/from16 v7, v24

    :cond_4b
    :goto_73
    const/4 v6, -0x1

    add-int/2addr v7, v6

    if-ltz v7, :cond_4c

    :try_start_45
    aget-object v6, v28, v7

    if-eqz v6, :cond_4b

    iget v10, v6, Lluaj/i;->f1731b:I

    if-lt v10, v3, :cond_4b

    invoke-virtual {v6}, Lluaj/i;->a()V

    const/4 v6, 0x0

    aput-object v6, v28, v7
    :try_end_45
    .catch Lluaj/d; {:try_start_45 .. :try_end_45} :catch_28
    .catch Ljava/lang/StackOverflowError; {:try_start_45 .. :try_end_45} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_45 .. :try_end_45} :catch_1e
    .catchall {:try_start_45 .. :try_end_45} :catchall_10

    goto :goto_73

    :catchall_10
    move-exception v0

    move-object v2, v0

    goto/16 :goto_40

    :catch_28
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    move v6, v7

    move v4, v11

    move v3, v14

    goto/16 :goto_4

    :cond_4c
    move/from16 v23, v3

    move/from16 v26, v7

    goto/16 :goto_63

    :pswitch_18
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    shr-int/lit8 v7, v14, 0xe

    and-int/lit16 v7, v7, 0x1ff

    add-int/lit8 v10, v6, 0x1

    if-le v7, v10, :cond_4e

    :try_start_46
    aget-object v10, v2, v7

    invoke-virtual {v10}, Lluaj/LuaValue;->s0()Lgg_f/a;

    move-result-object v10

    :goto_74
    const/4 v11, -0x1

    add-int/2addr v7, v11

    if-lt v7, v6, :cond_4d

    aget-object v11, v2, v7

    invoke-virtual {v10, v11}, Lgg_f/a;->g(Lluaj/LuaValue;)Lgg_f/a;

    goto :goto_74

    :catch_29
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    move v11, v7

    goto/16 :goto_68

    :cond_4d
    invoke-virtual {v10}, Lgg_f/a;->m()Lluaj/LuaValue;

    move-result-object v10

    aput-object v10, v2, v3

    :goto_75
    move/from16 v23, v3

    move/from16 v26, v6

    move/from16 v27, v7

    move-object v6, v8

    goto/16 :goto_58

    :cond_4e
    add-int/lit8 v10, v7, -0x1

    aget-object v10, v2, v10

    aget-object v11, v2, v7

    invoke-virtual {v10, v11}, Lluaj/LuaValue;->K0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v10

    aput-object v10, v2, v3
    :try_end_46
    .catch Lluaj/d; {:try_start_46 .. :try_end_46} :catch_29
    .catch Ljava/lang/StackOverflowError; {:try_start_46 .. :try_end_46} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_46 .. :try_end_46} :catch_1e
    .catchall {:try_start_46 .. :try_end_46} :catchall_b

    goto :goto_75

    :pswitch_19
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    :try_start_47
    aget-object v6, v2, v6

    invoke-virtual {v6}, Lluaj/LuaValue;->r1()Lluaj/LuaValue;

    move-result-object v6

    aput-object v6, v2, v3

    goto/16 :goto_64

    :pswitch_1a
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    aget-object v6, v2, v6

    invoke-virtual {v6}, Lluaj/LuaValue;->B1()Lluaj/LuaValue;

    move-result-object v6

    aput-object v6, v2, v3

    goto/16 :goto_64

    :pswitch_1b
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    aget-object v6, v2, v6

    invoke-virtual {v6}, Lluaj/LuaValue;->A1()Lluaj/LuaValue;

    move-result-object v6

    aput-object v6, v2, v3
    :try_end_47
    .catch Lluaj/d; {:try_start_47 .. :try_end_47} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_47 .. :try_end_47} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_47 .. :try_end_47} :catch_1e
    .catchall {:try_start_47 .. :try_end_47} :catchall_b

    goto/16 :goto_64

    :pswitch_1c
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    const/16 v7, 0xff

    if-le v6, v7, :cond_4f

    and-int/lit16 v7, v6, 0xff

    :try_start_48
    aget-object v7, v30, v7

    goto :goto_76

    :cond_4f
    aget-object v7, v2, v6
    :try_end_48
    .catch Lluaj/d; {:try_start_48 .. :try_end_48} :catch_26
    .catch Ljava/lang/StackOverflowError; {:try_start_48 .. :try_end_48} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_48 .. :try_end_48} :catch_1e
    .catchall {:try_start_48 .. :try_end_48} :catchall_b

    :goto_76
    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v11, v10, 0x1ff

    const/16 v12, 0xff

    if-le v11, v12, :cond_50

    and-int/lit16 v10, v10, 0xff

    :try_start_49
    aget-object v10, v30, v10

    goto :goto_77

    :cond_50
    aget-object v10, v2, v11

    :goto_77
    invoke-virtual {v7, v10}, Lluaj/LuaValue;->Q1(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    aput-object v7, v2, v3
    :try_end_49
    .catch Lluaj/d; {:try_start_49 .. :try_end_49} :catch_27
    .catch Ljava/lang/StackOverflowError; {:try_start_49 .. :try_end_49} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_49 .. :try_end_49} :catch_1e
    .catchall {:try_start_49 .. :try_end_49} :catchall_b

    goto/16 :goto_6c

    :pswitch_1d
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    const/16 v7, 0xff

    if-le v6, v7, :cond_51

    and-int/lit16 v7, v6, 0xff

    :try_start_4a
    aget-object v7, v30, v7

    goto :goto_78

    :cond_51
    aget-object v7, v2, v6
    :try_end_4a
    .catch Lluaj/d; {:try_start_4a .. :try_end_4a} :catch_26
    .catch Ljava/lang/StackOverflowError; {:try_start_4a .. :try_end_4a} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_4a .. :try_end_4a} :catch_1e
    .catchall {:try_start_4a .. :try_end_4a} :catchall_b

    :goto_78
    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v11, v10, 0x1ff

    const/16 v12, 0xff

    if-le v11, v12, :cond_52

    and-int/lit16 v10, v10, 0xff

    :try_start_4b
    aget-object v10, v30, v10

    goto :goto_79

    :cond_52
    aget-object v10, v2, v11

    :goto_79
    invoke-virtual {v7, v10}, Lluaj/LuaValue;->y1(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    aput-object v7, v2, v3
    :try_end_4b
    .catch Lluaj/d; {:try_start_4b .. :try_end_4b} :catch_27
    .catch Ljava/lang/StackOverflowError; {:try_start_4b .. :try_end_4b} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_4b .. :try_end_4b} :catch_1e
    .catchall {:try_start_4b .. :try_end_4b} :catchall_b

    goto/16 :goto_6c

    :pswitch_1e
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    const/16 v7, 0xff

    if-le v6, v7, :cond_53

    and-int/lit16 v7, v6, 0xff

    :try_start_4c
    aget-object v7, v30, v7

    goto :goto_7a

    :cond_53
    aget-object v7, v2, v6
    :try_end_4c
    .catch Lluaj/d; {:try_start_4c .. :try_end_4c} :catch_26
    .catch Ljava/lang/StackOverflowError; {:try_start_4c .. :try_end_4c} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_4c .. :try_end_4c} :catch_1e
    .catchall {:try_start_4c .. :try_end_4c} :catchall_b

    :goto_7a
    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v11, v10, 0x1ff

    const/16 v12, 0xff

    if-le v11, v12, :cond_54

    and-int/lit16 v10, v10, 0xff

    :try_start_4d
    aget-object v10, v30, v10

    goto :goto_7b

    :cond_54
    aget-object v10, v2, v11

    :goto_7b
    invoke-virtual {v7, v10}, Lluaj/LuaValue;->O0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    aput-object v7, v2, v3
    :try_end_4d
    .catch Lluaj/d; {:try_start_4d .. :try_end_4d} :catch_27
    .catch Ljava/lang/StackOverflowError; {:try_start_4d .. :try_end_4d} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_4d .. :try_end_4d} :catch_1e
    .catchall {:try_start_4d .. :try_end_4d} :catchall_b

    goto/16 :goto_6c

    :pswitch_1f
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    const/16 v7, 0xff

    if-le v6, v7, :cond_55

    and-int/lit16 v7, v6, 0xff

    :try_start_4e
    aget-object v7, v30, v7

    goto :goto_7c

    :cond_55
    aget-object v7, v2, v6
    :try_end_4e
    .catch Lluaj/d; {:try_start_4e .. :try_end_4e} :catch_26
    .catch Ljava/lang/StackOverflowError; {:try_start_4e .. :try_end_4e} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_4e .. :try_end_4e} :catch_1e
    .catchall {:try_start_4e .. :try_end_4e} :catchall_b

    :goto_7c
    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v11, v10, 0x1ff

    const/16 v12, 0xff

    if-le v11, v12, :cond_56

    and-int/lit16 v10, v10, 0xff

    :try_start_4f
    aget-object v10, v30, v10

    goto :goto_7d

    :cond_56
    aget-object v10, v2, v11

    :goto_7d
    invoke-virtual {v7, v10}, Lluaj/LuaValue;->z1(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    aput-object v7, v2, v3
    :try_end_4f
    .catch Lluaj/d; {:try_start_4f .. :try_end_4f} :catch_27
    .catch Ljava/lang/StackOverflowError; {:try_start_4f .. :try_end_4f} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_4f .. :try_end_4f} :catch_1e
    .catchall {:try_start_4f .. :try_end_4f} :catchall_b

    goto/16 :goto_6c

    :pswitch_20
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    const/16 v7, 0xff

    if-le v6, v7, :cond_57

    and-int/lit16 v7, v6, 0xff

    :try_start_50
    aget-object v7, v30, v7

    goto :goto_7e

    :cond_57
    aget-object v7, v2, v6
    :try_end_50
    .catch Lluaj/d; {:try_start_50 .. :try_end_50} :catch_26
    .catch Ljava/lang/StackOverflowError; {:try_start_50 .. :try_end_50} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_50 .. :try_end_50} :catch_1e
    .catchall {:try_start_50 .. :try_end_50} :catchall_b

    :goto_7e
    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v11, v10, 0x1ff

    const/16 v12, 0xff

    if-le v11, v12, :cond_58

    and-int/lit16 v10, v10, 0xff

    :try_start_51
    aget-object v10, v30, v10

    goto :goto_7f

    :cond_58
    aget-object v10, v2, v11

    :goto_7f
    invoke-virtual {v7, v10}, Lluaj/LuaValue;->r2(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    aput-object v7, v2, v3
    :try_end_51
    .catch Lluaj/d; {:try_start_51 .. :try_end_51} :catch_27
    .catch Ljava/lang/StackOverflowError; {:try_start_51 .. :try_end_51} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_51 .. :try_end_51} :catch_1e
    .catchall {:try_start_51 .. :try_end_51} :catchall_b

    goto/16 :goto_6c

    :pswitch_21
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v6, v14, 0x17

    const/16 v7, 0xff

    if-le v6, v7, :cond_59

    and-int/lit16 v7, v6, 0xff

    :try_start_52
    aget-object v7, v30, v7

    goto :goto_80

    :cond_59
    aget-object v7, v2, v6
    :try_end_52
    .catch Lluaj/d; {:try_start_52 .. :try_end_52} :catch_26
    .catch Ljava/lang/StackOverflowError; {:try_start_52 .. :try_end_52} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_52 .. :try_end_52} :catch_1e
    .catchall {:try_start_52 .. :try_end_52} :catchall_b

    :goto_80
    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v11, v10, 0x1ff

    const/16 v12, 0xff

    if-le v11, v12, :cond_5a

    and-int/lit16 v10, v10, 0xff

    :try_start_53
    aget-object v10, v30, v10

    goto :goto_81

    :cond_5a
    aget-object v10, v2, v11

    :goto_81
    invoke-virtual {v7, v10}, Lluaj/LuaValue;->j0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v7

    aput-object v7, v2, v3
    :try_end_53
    .catch Lluaj/d; {:try_start_53 .. :try_end_53} :catch_27
    .catch Ljava/lang/StackOverflowError; {:try_start_53 .. :try_end_53} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_53 .. :try_end_53} :catch_1e
    .catchall {:try_start_53 .. :try_end_53} :catchall_b

    goto/16 :goto_6c

    :pswitch_22
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    add-int/lit8 v6, v3, 0x1

    ushr-int/lit8 v7, v14, 0x17

    :try_start_54
    aget-object v7, v2, v7

    aput-object v7, v2, v6
    :try_end_54
    .catch Lluaj/d; {:try_start_54 .. :try_end_54} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_54 .. :try_end_54} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_54 .. :try_end_54} :catch_1e
    .catchall {:try_start_54 .. :try_end_54} :catchall_b

    shr-int/lit8 v6, v14, 0xe

    and-int/lit16 v10, v6, 0x1ff

    const/16 v11, 0xff

    if-le v10, v11, :cond_5b

    and-int/lit16 v6, v6, 0xff

    :try_start_55
    aget-object v6, v30, v6

    goto :goto_82

    :catch_2a
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    move v11, v10

    move v3, v14

    move/from16 v6, v26

    goto/16 :goto_56

    :cond_5b
    aget-object v6, v2, v10

    :goto_82
    invoke-virtual {v7, v6}, Lluaj/LuaValue;->U0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v6

    aput-object v6, v2, v3
    :try_end_55
    .catch Lluaj/d; {:try_start_55 .. :try_end_55} :catch_2a
    .catch Ljava/lang/StackOverflowError; {:try_start_55 .. :try_end_55} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_55 .. :try_end_55} :catch_1e
    .catchall {:try_start_55 .. :try_end_55} :catchall_b

    move/from16 v23, v3

    move-object v6, v8

    move/from16 v27, v10

    goto/16 :goto_58

    :pswitch_23
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    :try_start_56
    new-instance v6, Lluaj/LuaTable;

    ushr-int/lit8 v7, v14, 0x17

    shr-int/lit8 v10, v14, 0xe

    and-int/lit16 v10, v10, 0x1ff

    invoke-direct {v6, v7, v10}, Lluaj/LuaTable;-><init>(II)V

    aput-object v6, v2, v3

    goto/16 :goto_64

    :pswitch_24
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object/from16 v31, v10

    move-object/from16 v9, v25

    aget-object v6, v2, v3
    :try_end_56
    .catch Lluaj/d; {:try_start_56 .. :try_end_56} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_56 .. :try_end_56} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_56 .. :try_end_56} :catch_1e
    .catchall {:try_start_56 .. :try_end_56} :catchall_b

    ushr-int/lit8 v7, v14, 0x17

    const/16 v10, 0xff

    if-le v7, v10, :cond_5c

    and-int/lit16 v10, v7, 0xff

    :try_start_57
    aget-object v10, v30, v10

    goto :goto_83

    :catch_2b
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    move v6, v7

    goto/16 :goto_66

    :cond_5c
    aget-object v10, v2, v7
    :try_end_57
    .catch Lluaj/d; {:try_start_57 .. :try_end_57} :catch_2b
    .catch Ljava/lang/StackOverflowError; {:try_start_57 .. :try_end_57} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_57 .. :try_end_57} :catch_1e
    .catchall {:try_start_57 .. :try_end_57} :catchall_b

    :goto_83
    shr-int/lit8 v11, v14, 0xe

    and-int/lit16 v12, v11, 0x1ff

    const/16 v15, 0xff

    if-le v12, v15, :cond_5d

    and-int/lit16 v11, v11, 0xff

    :try_start_58
    aget-object v11, v30, v11

    goto :goto_84

    :catch_2c
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    move v6, v7

    move v11, v12

    goto/16 :goto_68

    :cond_5d
    aget-object v11, v2, v12

    :goto_84
    invoke-virtual {v6, v10, v11}, Lluaj/LuaValue;->j2(Lluaj/LuaValue;Lluaj/LuaValue;)V
    :try_end_58
    .catch Lluaj/d; {:try_start_58 .. :try_end_58} :catch_2c
    .catch Ljava/lang/StackOverflowError; {:try_start_58 .. :try_end_58} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_58 .. :try_end_58} :catch_1e
    .catchall {:try_start_58 .. :try_end_58} :catchall_b

    move/from16 v23, v3

    move/from16 v26, v7

    move-object v6, v8

    move/from16 v27, v12

    goto/16 :goto_58

    :pswitch_25
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    :try_start_59
    array-length v6, v7

    ushr-int/lit8 v10, v14, 0x17

    if-ge v10, v6, :cond_5e

    aget-object v6, v7, v10

    aget-object v10, v2, v3

    invoke-virtual {v6, v10}, Lluaj/i;->c(Lluaj/LuaValue;)V

    move/from16 v34, v5

    goto/16 :goto_8e

    :cond_5e
    const/4 v5, 0x4

    invoke-static {v5, v10, v6}, Lluaj/LuaClosure;->g3(III)Lluaj/d;

    move-result-object v5

    throw v5

    :pswitch_26
    move v5, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    array-length v6, v7

    if-ge v3, v6, :cond_61

    aget-object v6, v7, v3

    invoke-virtual {v6}, Lluaj/i;->b()Lluaj/LuaValue;

    move-result-object v6
    :try_end_59
    .catch Lluaj/d; {:try_start_59 .. :try_end_59} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_59 .. :try_end_59} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_59 .. :try_end_59} :catch_1e
    .catchall {:try_start_59 .. :try_end_59} :catchall_b

    ushr-int/lit8 v10, v14, 0x17

    const/16 v11, 0xff

    if-le v10, v11, :cond_5f

    and-int/lit16 v11, v10, 0xff

    :try_start_5a
    aget-object v11, v30, v11

    goto :goto_85

    :catch_2d
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    move v6, v10

    goto/16 :goto_66

    :cond_5f
    aget-object v11, v2, v10
    :try_end_5a
    .catch Lluaj/d; {:try_start_5a .. :try_end_5a} :catch_2d
    .catch Ljava/lang/StackOverflowError; {:try_start_5a .. :try_end_5a} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_5a .. :try_end_5a} :catch_1e
    .catchall {:try_start_5a .. :try_end_5a} :catchall_b

    :goto_85
    shr-int/lit8 v12, v14, 0xe

    and-int/lit16 v15, v12, 0x1ff

    move/from16 v34, v5

    const/16 v5, 0xff

    if-le v15, v5, :cond_60

    and-int/lit16 v5, v12, 0xff

    :try_start_5b
    aget-object v5, v30, v5

    goto :goto_86

    :catch_2e
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    move v6, v10

    move v3, v14

    move v11, v15

    goto/16 :goto_56

    :cond_60
    aget-object v5, v2, v15

    :goto_86
    invoke-virtual {v6, v11, v5}, Lluaj/LuaValue;->j2(Lluaj/LuaValue;Lluaj/LuaValue;)V
    :try_end_5b
    .catch Lluaj/d; {:try_start_5b .. :try_end_5b} :catch_2e
    .catch Ljava/lang/StackOverflowError; {:try_start_5b .. :try_end_5b} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_5b .. :try_end_5b} :catch_1e
    .catchall {:try_start_5b .. :try_end_5b} :catchall_b

    move/from16 v23, v3

    move-object v6, v8

    move/from16 v26, v10

    move/from16 v27, v15

    :goto_87
    move/from16 v11, v33

    :goto_88
    move/from16 v5, v34

    goto/16 :goto_59

    :cond_61
    const/4 v5, 0x3

    :try_start_5c
    invoke-static {v5, v3, v6}, Lluaj/LuaClosure;->g3(III)Lluaj/d;

    move-result-object v5

    throw v5

    :pswitch_27
    move/from16 v34, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v5, v14, 0x17

    aget-object v5, v2, v5
    :try_end_5c
    .catch Lluaj/d; {:try_start_5c .. :try_end_5c} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_5c .. :try_end_5c} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_5c .. :try_end_5c} :catch_1e
    .catchall {:try_start_5c .. :try_end_5c} :catchall_b

    shr-int/lit8 v6, v14, 0xe

    and-int/lit16 v10, v6, 0x1ff

    const/16 v11, 0xff

    if-le v10, v11, :cond_62

    and-int/lit16 v6, v6, 0xff

    :try_start_5d
    aget-object v6, v30, v6

    goto :goto_89

    :cond_62
    aget-object v6, v2, v10

    :goto_89
    invoke-virtual {v5, v6}, Lluaj/LuaValue;->U0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v5

    aput-object v5, v2, v3
    :try_end_5d
    .catch Lluaj/d; {:try_start_5d .. :try_end_5d} :catch_2a
    .catch Ljava/lang/StackOverflowError; {:try_start_5d .. :try_end_5d} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_5d .. :try_end_5d} :catch_1e
    .catchall {:try_start_5d .. :try_end_5d} :catchall_b

    :goto_8a
    move/from16 v23, v3

    move-object v6, v8

    move/from16 v27, v10

    goto :goto_87

    :pswitch_28
    move/from16 v34, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    :try_start_5e
    array-length v5, v7

    ushr-int/lit8 v10, v14, 0x17

    if-ge v10, v5, :cond_64

    aget-object v5, v7, v10

    invoke-virtual {v5}, Lluaj/i;->b()Lluaj/LuaValue;

    move-result-object v5
    :try_end_5e
    .catch Lluaj/d; {:try_start_5e .. :try_end_5e} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_5e .. :try_end_5e} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_5e .. :try_end_5e} :catch_1e
    .catchall {:try_start_5e .. :try_end_5e} :catchall_b

    shr-int/lit8 v6, v14, 0xe

    and-int/lit16 v10, v6, 0x1ff

    const/16 v11, 0xff

    if-le v10, v11, :cond_63

    and-int/lit16 v6, v6, 0xff

    :try_start_5f
    aget-object v6, v30, v6

    goto :goto_8b

    :cond_63
    aget-object v6, v2, v10

    :goto_8b
    invoke-virtual {v5, v6}, Lluaj/LuaValue;->U0(Lluaj/LuaValue;)Lluaj/LuaValue;

    move-result-object v5

    aput-object v5, v2, v3
    :try_end_5f
    .catch Lluaj/d; {:try_start_5f .. :try_end_5f} :catch_2a
    .catch Ljava/lang/StackOverflowError; {:try_start_5f .. :try_end_5f} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_5f .. :try_end_5f} :catch_1e
    .catchall {:try_start_5f .. :try_end_5f} :catchall_b

    goto :goto_8a

    :cond_64
    :try_start_60
    invoke-static {v6, v10, v5}, Lluaj/LuaClosure;->g3(III)Lluaj/d;

    move-result-object v5

    throw v5

    :pswitch_29
    move/from16 v34, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    array-length v5, v7

    ushr-int/lit8 v6, v14, 0x17

    if-ge v6, v5, :cond_65

    aget-object v5, v7, v6

    invoke-virtual {v5}, Lluaj/i;->b()Lluaj/LuaValue;

    move-result-object v5

    aput-object v5, v2, v3

    goto :goto_8e

    :cond_65
    const/4 v7, 0x1

    invoke-static {v7, v6, v5}, Lluaj/LuaClosure;->g3(III)Lluaj/d;

    move-result-object v5

    throw v5
    :try_end_60
    .catch Lluaj/d; {:try_start_60 .. :try_end_60} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_60 .. :try_end_60} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_60 .. :try_end_60} :catch_1e
    .catchall {:try_start_60 .. :try_end_60} :catchall_b

    :pswitch_2a
    move/from16 v34, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v5, v14, 0x17

    :goto_8c
    add-int/lit8 v26, v5, -0x1

    if-ltz v5, :cond_66

    add-int/lit8 v5, v3, 0x1

    :try_start_61
    aput-object v16, v2, v3
    :try_end_61
    .catch Lluaj/d; {:try_start_61 .. :try_end_61} :catch_2f
    .catch Ljava/lang/StackOverflowError; {:try_start_61 .. :try_end_61} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_61 .. :try_end_61} :catch_1e
    .catchall {:try_start_61 .. :try_end_61} :catchall_b

    move v3, v5

    move/from16 v5, v26

    goto :goto_8c

    :catch_2f
    move-exception v0

    move/from16 v22, v5

    move v3, v14

    move/from16 v6, v26

    move/from16 v11, v27

    move/from16 v4, v33

    :goto_8d
    move-object v5, v0

    goto/16 :goto_9a

    :cond_66
    :goto_8e
    move/from16 v23, v3

    move-object v6, v8

    goto/16 :goto_87

    :pswitch_2b
    move/from16 v34, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v5, v14, 0x17

    if-eqz v5, :cond_67

    move-object/from16 v5, v17

    goto :goto_8f

    :cond_67
    move-object/from16 v5, v18

    :goto_8f
    :try_start_62
    aput-object v5, v2, v3
    :try_end_62
    .catch Lluaj/d; {:try_start_62 .. :try_end_62} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_62 .. :try_end_62} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_62 .. :try_end_62} :catch_1e
    .catchall {:try_start_62 .. :try_end_62} :catchall_b

    and-int v5, v14, v23

    if-eqz v5, :cond_66

    add-int/lit8 v11, v33, 0x1

    move/from16 v23, v3

    :goto_90
    move-object v6, v8

    goto/16 :goto_88

    :pswitch_2c
    move/from16 v34, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    add-int/lit8 v11, v33, 0x1

    :try_start_63
    aget v5, v35, v11
    :try_end_63
    .catch Lluaj/d; {:try_start_63 .. :try_end_63} :catch_31
    .catch Ljava/lang/StackOverflowError; {:try_start_63 .. :try_end_63} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_63 .. :try_end_63} :catch_1e
    .catchall {:try_start_63 .. :try_end_63} :catchall_10

    and-int/lit8 v6, v5, 0x3f

    const/16 v10, 0x27

    if-eq v6, v10, :cond_69

    :try_start_64
    new-instance v7, Lluaj/d;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "EXTRAARG expected after LOADKX, got "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v9, Lluaj/g;->f1717c:[Ljava/lang/String;

    array-length v10, v9

    const/4 v12, 0x1

    sub-int/2addr v10, v12

    if-ge v6, v10, :cond_68

    aget-object v6, v9, v6

    goto :goto_91

    :catch_30
    move-exception v0

    move/from16 v22, v3

    move v3, v5

    move v4, v11

    move/from16 v6, v26

    move/from16 v11, v27

    goto :goto_8d

    :cond_68
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "UNKNOWN_OP_"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    :goto_91
    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v7, v6}, Lluaj/d;-><init>(Ljava/lang/String;)V

    throw v7

    :cond_69
    ushr-int/lit8 v6, v5, 0x6

    aget-object v6, v30, v6

    aput-object v6, v2, v3
    :try_end_64
    .catch Lluaj/d; {:try_start_64 .. :try_end_64} :catch_30
    .catch Ljava/lang/StackOverflowError; {:try_start_64 .. :try_end_64} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_64 .. :try_end_64} :catch_1e
    .catchall {:try_start_64 .. :try_end_64} :catchall_10

    move/from16 v23, v3

    move v14, v5

    goto :goto_90

    :catch_31
    move-exception v0

    move-object v5, v0

    move/from16 v22, v3

    goto/16 :goto_44

    :pswitch_2d
    move/from16 v34, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v5, v14, 0xe

    :try_start_65
    aget-object v5, v30, v5

    aput-object v5, v2, v3

    goto/16 :goto_8e

    :pswitch_2e
    move/from16 v34, v4

    move-object/from16 v35, v8

    move/from16 v33, v11

    move-object/from16 v36, v12

    move-object/from16 v19, v13

    move-object/from16 v37, v15

    move-object/from16 v13, v28

    move-object/from16 v4, v30

    move-object/from16 v8, v31

    move-object/from16 v28, v7

    move-object/from16 v30, v9

    move-object v7, v10

    move-object/from16 v9, v25

    ushr-int/lit8 v5, v14, 0x17

    aget-object v5, v2, v5

    aput-object v5, v2, v3
    :try_end_65
    .catch Lluaj/d; {:try_start_65 .. :try_end_65} :catch_20
    .catch Ljava/lang/StackOverflowError; {:try_start_65 .. :try_end_65} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_65 .. :try_end_65} :catch_1e
    .catchall {:try_start_65 .. :try_end_65} :catchall_b

    goto/16 :goto_8e

    :goto_92
    add-int/2addr v11, v3

    move-object v10, v7

    move-object/from16 v25, v9

    move/from16 v22, v14

    move-object/from16 v7, v28

    move-object/from16 v3, v29

    move-object/from16 v9, v30

    move-object/from16 v8, v35

    move-object/from16 v12, v36

    move-object/from16 v15, v37

    move-object v14, v13

    move-object/from16 v13, v19

    move/from16 v38, v5

    move-object v5, v4

    move/from16 v4, v38

    goto/16 :goto_2

    :catch_32
    move-exception v0

    move-object v4, v5

    goto/16 :goto_60

    :catch_33
    move-exception v0

    move/from16 v33, v11

    move-object/from16 v13, v28

    move-object/from16 v28, v7

    :goto_93
    move-object v5, v0

    move/from16 v3, v22

    move/from16 v22, v23

    goto/16 :goto_54

    :catchall_11
    move-exception v0

    move-object/from16 v28, v7

    move/from16 v33, v11

    move-object v13, v14

    goto/16 :goto_50

    :catch_34
    move-exception v0

    move-object/from16 v28, v7

    :goto_94
    move-object v13, v14

    goto/16 :goto_51

    :catch_35
    move-exception v0

    move-object v4, v5

    move-object/from16 v28, v7

    :goto_95
    move-object v13, v14

    goto/16 :goto_52

    :catch_36
    move-exception v0

    move-object/from16 v28, v7

    move/from16 v33, v11

    move-object v13, v14

    goto :goto_93

    :cond_6a
    move-object v4, v5

    move-object/from16 v28, v7

    move/from16 v33, v11

    move-object v13, v14

    :try_start_66
    new-instance v3, Ljava/lang/InterruptedException;

    const-string v5, "Script thread interrupted"

    invoke-direct {v3, v5}, Ljava/lang/InterruptedException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_66
    .catch Lluaj/d; {:try_start_66 .. :try_end_66} :catch_37
    .catch Ljava/lang/StackOverflowError; {:try_start_66 .. :try_end_66} :catch_1f
    .catch Ljava/lang/InterruptedException; {:try_start_66 .. :try_end_66} :catch_1e
    .catchall {:try_start_66 .. :try_end_66} :catchall_b

    :catch_37
    move-exception v0

    goto :goto_93

    :catchall_12
    move-exception v0

    move-object/from16 v28, v7

    move/from16 v24, v11

    move-object v13, v14

    move-object v2, v0

    const/4 v3, 0x0

    goto :goto_96

    :catch_38
    move-exception v0

    move-object/from16 v28, v7

    move/from16 v24, v11

    goto :goto_94

    :catch_39
    move-exception v0

    move-object v4, v5

    move-object/from16 v28, v7

    move/from16 v24, v11

    goto :goto_95

    :catch_3a
    move-exception v0

    move-object/from16 v28, v7

    move/from16 v24, v11

    move-object v13, v14

    move-object v5, v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v6, 0x0

    const/4 v11, 0x0

    const/16 v22, 0x0

    goto :goto_9a

    :goto_96
    :try_start_67
    new-instance v4, Lluaj/d$a;

    invoke-direct {v4, v2}, Lluaj/d$a;-><init>(Ljava/lang/Throwable;)V

    iget-object v2, v1, Lluaj/LuaClosure;->T:Lluaj/Globals;

    iget-object v5, v1, Lluaj/LuaClosure;->R:Lluaj/h;

    const/4 v6, 0x0

    invoke-static {v2, v4, v5, v3, v6}, Lluaj/LuaClosure;->c3(Lluaj/Globals;Lluaj/d;Lluaj/h;ILjava/lang/String;)V

    throw v4

    :catchall_13
    move-exception v0

    move-object v2, v0

    goto/16 :goto_a5

    :goto_97
    const-string v3, "Interrupted closure"

    invoke-static {v3, v2}, Landroid/ext/e1;->s(Ljava/lang/String;Ljava/lang/Throwable;)I

    new-instance v3, Lluaj/d;

    invoke-direct {v3, v2}, Lluaj/d;-><init>(Ljava/lang/Throwable;)V

    throw v3

    :goto_98
    invoke-virtual {v2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v3

    new-instance v5, Lluaj/d$b;

    if-nez v3, :cond_6b

    const-string v3, "stack overflow"

    goto :goto_99

    :cond_6b
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "stack overflow ("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_99
    invoke-direct {v5, v3, v2}, Lluaj/d$b;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    :goto_9a
    iget-object v7, v5, Lluaj/d;->f1712e:Ljava/lang/String;

    if-nez v7, :cond_79

    and-int/lit8 v7, v3, 0x3f

    packed-switch v7, :pswitch_data_1

    :pswitch_2f
    goto/16 :goto_9f

    :pswitch_30
    const/16 v3, 0xff

    if-gt v6, v3, :cond_6d

    aget-object v3, v2, v6

    invoke-virtual {v3}, Lluaj/LuaValue;->k1()Z

    move-result v3

    if-nez v3, :cond_6c

    goto/16 :goto_9d

    :cond_6c
    const/16 v3, 0xff

    :cond_6d
    if-gt v11, v3, :cond_75

    aget-object v2, v2, v11

    invoke-virtual {v2}, Lluaj/LuaValue;->k1()Z

    move-result v2

    if-nez v2, :cond_75

    goto/16 :goto_9e

    :pswitch_31
    const/16 v3, 0xff

    if-gt v6, v3, :cond_6f

    aget-object v3, v2, v6

    invoke-virtual {v3}, Lluaj/LuaValue;->n1()Z

    move-result v3

    if-nez v3, :cond_6e

    goto :goto_9d

    :cond_6e
    const/16 v3, 0xff

    :cond_6f
    if-gt v11, v3, :cond_75

    aget-object v2, v2, v11

    invoke-virtual {v2}, Lluaj/LuaValue;->n1()Z

    move-result v2

    if-nez v2, :cond_75

    goto :goto_9e

    :pswitch_32
    ushr-int/lit8 v6, v3, 0x17

    shr-int/lit8 v3, v3, 0xe

    and-int/lit16 v3, v3, 0x1ff

    const/4 v7, 0x1

    add-int/2addr v6, v7

    if-le v3, v6, :cond_71

    aget-object v6, v2, v11

    invoke-virtual {v6}, Lluaj/LuaValue;->n1()Z

    move-result v6

    if-nez v6, :cond_70

    goto :goto_9e

    :cond_70
    aget-object v2, v2, v3

    invoke-virtual {v2}, Lluaj/LuaValue;->n1()Z

    move-result v2

    if-nez v2, :cond_75

    :goto_9b
    move v6, v3

    :goto_9c
    const/4 v3, -0x1

    goto :goto_a1

    :cond_71
    add-int/lit8 v3, v11, -0x1

    aget-object v6, v2, v3

    invoke-virtual {v6}, Lluaj/LuaValue;->n1()Z

    move-result v6

    if-nez v6, :cond_72

    goto :goto_9b

    :cond_72
    aget-object v2, v2, v11

    invoke-virtual {v2}, Lluaj/LuaValue;->n1()Z

    move-result v2

    if-nez v2, :cond_75

    goto :goto_9e

    :pswitch_33
    const/16 v3, 0xff

    if-gt v6, v3, :cond_74

    aget-object v3, v2, v6

    invoke-virtual {v3}, Lluaj/LuaValue;->m1()Z

    move-result v3

    if-nez v3, :cond_73

    :goto_9d
    goto :goto_9c

    :cond_73
    const/16 v3, 0xff

    :cond_74
    if-gt v11, v3, :cond_75

    aget-object v2, v2, v11

    invoke-virtual {v2}, Lluaj/LuaValue;->m1()Z

    move-result v2

    if-nez v2, :cond_75

    :goto_9e
    move v6, v11

    goto :goto_9c

    :cond_75
    :goto_9f
    const/4 v3, -0x1

    :goto_a0
    const/4 v6, -0x1

    goto :goto_a1

    :pswitch_34
    move/from16 v6, v22

    goto :goto_9c

    :pswitch_35
    move/from16 v3, v22

    goto :goto_a0

    :pswitch_36
    ushr-int/lit8 v3, v3, 0x17

    goto :goto_9b

    :pswitch_37
    ushr-int/lit8 v3, v3, 0x17

    goto :goto_a0

    :goto_a1
    if-ltz v3, :cond_77

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "upvalue \'"

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v6, v1, Lluaj/LuaClosure;->R:Lluaj/h;

    iget-object v6, v6, Lluaj/h;->f1728f:[Lgg_f/d;

    array-length v7, v6

    if-ge v3, v7, :cond_76

    aget-object v3, v6, v3

    iget-object v3, v3, Lgg_f/d;->f1565a:Lluaj/LuaString;

    goto :goto_a2

    :cond_76
    const-string v3, "?"

    :goto_a2
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_a3

    :cond_77
    iget-object v2, v1, Lluaj/LuaClosure;->R:Lluaj/h;

    invoke-static {v4, v6, v2}, Lluaj/lib/DebugLib;->f3(IILluaj/h;)Ljava/lang/String;

    move-result-object v2

    :goto_a3
    if-eqz v2, :cond_78

    const-string v3, "method "

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_78

    instance-of v3, v5, Lluaj/c;

    if-eqz v3, :cond_78

    new-instance v3, Lluaj/c;

    check-cast v5, Lluaj/c;

    invoke-direct {v3, v5}, Lluaj/c;-><init>(Lluaj/c;)V

    move-object v5, v3

    :cond_78
    iget-object v3, v1, Lluaj/LuaClosure;->T:Lluaj/Globals;

    iget-object v6, v1, Lluaj/LuaClosure;->R:Lluaj/h;

    invoke-static {v3, v5, v6, v4, v2}, Lluaj/LuaClosure;->c3(Lluaj/Globals;Lluaj/d;Lluaj/h;ILjava/lang/String;)V

    :cond_79
    instance-of v2, v5, Lluaj/d$b;

    if-eqz v2, :cond_7a

    sget v2, Lluaj/LuaClosure;->Y:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_7a

    invoke-virtual {v5}, Lluaj/d;->getCause()Ljava/lang/Throwable;

    move-result-object v2

    if-eqz v2, :cond_7a

    invoke-virtual {v2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Stack overflow 1: "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/ext/e1;->p(Ljava/lang/String;)I
    :try_end_67
    .catchall {:try_start_67 .. :try_end_67} :catchall_13

    :try_start_68
    const-string v3, "Stack overflow 2"

    invoke-static {v3, v2}, Landroid/ext/e1;->s(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_68
    .catchall {:try_start_68 .. :try_end_68} :catchall_14

    goto :goto_a4

    :catchall_14
    move-exception v0

    move-object v2, v0

    :try_start_69
    const-string v3, "Stack overflow 3"

    invoke-static {v3, v2}, Landroid/ext/e1;->s(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_69
    .catchall {:try_start_69 .. :try_end_69} :catchall_15

    goto :goto_a4

    :catchall_15
    :try_start_6a
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Stack overflow 4: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/ext/e1;->p(Ljava/lang/String;)I

    :cond_7a
    :goto_a4
    throw v5
    :try_end_6a
    .catchall {:try_start_6a .. :try_end_6a} :catchall_13

    :goto_a5
    if-eqz v28, :cond_7c

    move/from16 v11, v24

    const/4 v3, -0x1

    :cond_7b
    :goto_a6
    add-int/2addr v11, v3

    if-ltz v11, :cond_7c

    aget-object v4, v28, v11

    if-eqz v4, :cond_7b

    invoke-virtual {v4}, Lluaj/i;->a()V

    goto :goto_a6

    :cond_7c
    if-eqz v13, :cond_7d

    if-nez p3, :cond_7d

    invoke-virtual {v13}, Lluaj/lib/DebugLib;->l3()V

    :cond_7d
    sget-object v3, Lluaj/LuaValue;->f1676f:Lluaj/LuaValue;

    iput-object v3, v1, Lluaj/LuaClosure;->V:Lluaj/Varargs;

    sget v3, Lluaj/LuaClosure;->Y:I

    const/4 v4, 0x1

    sub-int/2addr v3, v4

    sput v3, Lluaj/LuaClosure;->Y:I

    throw v2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2e
        :pswitch_2d
        :pswitch_2c
        :pswitch_2b
        :pswitch_2a
        :pswitch_29
        :pswitch_28
        :pswitch_27
        :pswitch_26
        :pswitch_25
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch

    :sswitch_data_0
    .sparse-switch
        0x800000 -> :sswitch_9
        0x804000 -> :sswitch_8
        0x808000 -> :sswitch_7
        0x1000000 -> :sswitch_6
        0x1004000 -> :sswitch_5
        0x1008000 -> :sswitch_4
        0x1804000 -> :sswitch_3
        0x1808000 -> :sswitch_2
        0x2004000 -> :sswitch_1
        0x2008000 -> :sswitch_0
    .end sparse-switch

    :sswitch_data_1
    .sparse-switch
        0x800000 -> :sswitch_d
        0x804000 -> :sswitch_e
        0x808000 -> :sswitch_e
        0x1000000 -> :sswitch_c
        0x1004000 -> :sswitch_c
        0x1008000 -> :sswitch_c
        0x1804000 -> :sswitch_b
        0x1808000 -> :sswitch_b
        0x2004000 -> :sswitch_a
        0x2008000 -> :sswitch_a
    .end sparse-switch

    :pswitch_data_1
    .packed-switch 0x5
        :pswitch_37
        :pswitch_37
        :pswitch_36
        :pswitch_35
        :pswitch_37
        :pswitch_34
        :pswitch_2f
        :pswitch_36
        :pswitch_33
        :pswitch_33
        :pswitch_33
        :pswitch_33
        :pswitch_33
        :pswitch_33
        :pswitch_36
        :pswitch_36
        :pswitch_36
        :pswitch_32
        :pswitch_2f
        :pswitch_2f
        :pswitch_31
        :pswitch_31
        :pswitch_34
        :pswitch_36
        :pswitch_34
        :pswitch_34
        :pswitch_2f
        :pswitch_2f
        :pswitch_2f
        :pswitch_34
        :pswitch_2f
        :pswitch_34
        :pswitch_2f
        :pswitch_2f
        :pswitch_2f
        :pswitch_33
        :pswitch_36
        :pswitch_30
        :pswitch_30
        :pswitch_30
        :pswitch_30
        :pswitch_30
    .end packed-switch
.end method
